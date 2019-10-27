package GameProgram.Thread;

import cards.CardFactory;
import cards.MembershipCard;
import cards.OrdinaryCardFactory;
import cards.SeniorCardFactory;
import factory.AbstractFactory;
import factory.FoodFactoryA;
import factory.FoodFactoryB;
import foods.*;
import foods.lookup.ProductBy;
import foods.lookup.base.Specification;
import person.Customer;
import person.Person;
import sale.combo.AComboBuilder;
import sale.combo.BComboBuilder;
import sale.combo.ComboBuilder;
import sale.combo.ComboDirector;
import utils.info.ConstantTable;
import utils.info.PriceTable;

import java.util.*;

import static GameProgram.Thread.Common.*;

/**
 * @className: ShopkeeperThread
 * @author: Shidan Cheng
 * @description: 店长线程
 * @date: 5:57 下午 2019/10/27
 * @version: v1.0
 */
public class ShopkeeperThread implements Runnable {
    static public Scanner scanner = new Scanner(System.in);
    static private List<Person> hiredShopAssistant = new ArrayList<>();

    @Override
    public void run() {
        initFoodPrototypeList();
        showBlackboard();
        System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
        String command = "";
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "1":
                    showStoreInfo();
                    break;
                case "2":
                    showRepositoryInfo();
                    break;
                case "3":
                    showBuyFoodInfo();
                    break;
                case "4":
                    showCustomerInfo();
                    break;
                case "5":
                case "6":
                    showMessageInfo();
                    break;
                case "7":
                    worldClock.updateTheWorld();
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("[%s]> [ERROR] 指令不存在!\n", shopKeeper.getName());
                    break;

            }
            showBlackboard();
            System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }
    }

    //main 展板
    public static void showBlackboard() {
        System.out.println("* ============================================= *");
        System.out.printf("                     %5s                         \n", convenienceStore.getName());
        System.out.printf("                     第%d天                       \n", worldClock.getDay());
        System.out.printf("                     季节: %s                    \n", worldClock.getSeason());
        System.out.println("* ============================================= *");
        System.out.println("@=                   1. 设置店铺                =@");
        System.out.println("@=                   2. 查看仓库                =@");
        System.out.println("@=                   3. 进购食品                =@");
        System.out.println("@=                   4. 查看顾客                =@");
        System.out.println("@=                   5. 招聘店员                =@");
        System.out.println("@=                   6. 查看留言板              =@");
        System.out.println("@=                   7. 结束本天                =@");
        System.out.println("@=                   q. 结束游戏                =@");
        System.out.println("* ============================================= *");
    }


    /** ================================================================================= 菜单4【查看顾客】 START */
    //4. 查看顾客
    public static void showCustomerInfo() {
        showCustomerInfoBlackBoard();
        System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
        String command = "";
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "0":
                    servingCustomer(Integer.parseInt(command));
                    break;
                case "1":
                    servingCustomer(Integer.parseInt(command));
                    break;
                case "2":
                    servingCustomer(Integer.parseInt(command));
                    break;
                case "3":
                    servingCustomer(Integer.parseInt(command));
                    break;
                case "4":
                    servingCustomer(Integer.parseInt(command));
                    break;
                case "q":
                    return;
                default:
                    System.out.printf("[%s]> [ERROR] 指令不存在!\n", shopKeeper.getName());
                    break;
            }
            showCustomerInfoBlackBoard();
            System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }

    }

    //4. 查看顾客展板
    public static void showCustomerInfoBlackBoard() {
        System.out.println("* -------------------顾客列表--------------------*");
        for (int i = 0; i < customerList.size(); i++) {
            System.out.printf("|-顾客编号:\t%d\n", i);
            System.out.printf("| 顾客姓名:\t%s\n", customerList.get(i).getName());
            Customer customer = customerList.get(i);
            System.out.printf("| 顾客购买商品:\t%s\n", customerBuyMap.get(customer.getBuyType()));
            System.out.printf("| 顾客付款顺序:\t%s\n", customerList.get(i).getCheckoutFlow());
            System.out.println("|");
        }
        System.out.println("* ----------------------------------------------*");
        System.out.println("* ============================================= *");
        System.out.println("@=              请选择顾客编号进行接待            =@");
        System.out.println("@=                   q. 返回                    =@");
        System.out.println("* ============================================= *");
    }

    //4. 接待顾客
    public static void servingCustomer(int index) {
        if (index >= customerList.size() || index < 0) {
            System.out.printf("[%s]> [ERROR] 顾客不存在!\n", shopKeeper.getName());
        } else {
            Customer customer = customerList.get(index);
            String info = customerBuyMap.get(customer.getBuyType());
            List<Food> foodList = foodRepository.getFoodList();
            if (info.equals("A套餐")) {
                boolean flag = false;
                Food cola = null;
                Food tart = null;
                Food chips = null;
                for (int i = 0; i < foodList.size(); i++) {
                    if (foodList.get(i).getName().equals("可乐")) {
                        cola = foodList.get(i);
                    }
                    if (foodList.get(i).getName().equals("蛋挞")) {
                        tart = foodList.get(i);
                    }
                    if (foodList.get(i).getName().equals("薯片")) {
                        chips = foodList.get(i);
                    }
                    if (cola != null && tart != null && chips != null) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    System.out.printf("[%s]> [ERROR] 仓库内的可乐、蛋挞、薯片不足!\n", shopKeeper.getName());
                } else {
                    foodList.remove(cola);
                    foodList.remove(tart);
                    foodList.remove(chips);
                    ComboBuilder ACombo = new AComboBuilder();
                    ComboDirector director = new ComboDirector(ACombo);
                    customer.buy(director.getComboPrice());
                    convenienceStore.setMoney(convenienceStore.getMoney() + director.getComboPrice());
                    System.out.printf("[%s]> [SUCCESS] 成功出售A套餐, 获得金钱%d!\n", shopKeeper.getName(), director.getComboPrice());
                    customerList.remove(customer);
                }
            } else if (info.equals("B套餐")) {
                boolean flag = false;
                Food water = null;
                Food crispy = null;
                Food chocolate = null;
                for (int i = 0; i < foodList.size(); i++) {
                    if (foodList.get(i).getName().equals("矿泉水")) {
                        water = foodList.get(i);
                    }
                    if (foodList.get(i).getName().equals("蛋黄酥")) {
                        crispy = foodList.get(i);
                    }
                    if (foodList.get(i).getName().equals("巧克力")) {
                        chocolate = foodList.get(i);
                    }
                    if (water != null && crispy != null && chocolate != null) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    System.out.printf("[%s]> [ERROR] 仓库内的矿泉水、蛋黄酥、巧克力不足!\n", shopKeeper.getName());
                } else {
                    foodList.remove(water);
                    foodList.remove(crispy);
                    foodList.remove(chocolate);
                    ComboBuilder BCombo = new BComboBuilder();
                    ComboDirector director = new ComboDirector(BCombo);
                    customer.buy(director.getComboPrice());
                    convenienceStore.setMoney(convenienceStore.getMoney() + director.getComboPrice());
                    System.out.printf("[%s]> [SUCCESS] 成功出售B套餐, 获得金钱%d!\n", shopKeeper.getName(), director.getComboPrice());
                    customerList.remove(customer);
                }
            } else if (info.equals("办理普通会员卡")) {
                CardFactory ordinaryCardFactory = new OrdinaryCardFactory();
                MembershipCard cardOrdinary = ordinaryCardFactory.getCard(customer.getName());
                cardOrdinary.showMemberShipCard();
                customer.buy(PriceTable.ORDINARY_CARD);
                convenienceStore.setMoney(convenienceStore.getMoney()+PriceTable.ORDINARY_CARD);
                System.out.printf("[%s]> [SUCCESS] 成功办理普通会员卡, 获得金钱%d!\n", shopKeeper.getName(), PriceTable.ORDINARY_CARD);
                customerList.remove(customer);
            } else if (info.equals("办理高级会员卡")) {
                CardFactory seniorCardFactory=new SeniorCardFactory();
                MembershipCard cardSenior=seniorCardFactory.getCard(customer.getName());
                cardSenior.showMemberShipCard();
                customer.buy(PriceTable.SENIOR_CARD);
                convenienceStore.setMoney(convenienceStore.getMoney()+PriceTable.SENIOR_CARD);
                System.out.printf("[%s]> [SUCCESS] 成功办理普通会员卡, 获得金钱%d!\n", shopKeeper.getName(), PriceTable.SENIOR_CARD);
                customerList.remove(customer);

            } else {
                Food food = null;
                for (int i = 0; i < foodList.size(); i++) {
                    if (foodList.get(i).getName().equals(info)) {
                        food = foodList.get(i);
                        break;
                    }
                }
                if (food != null) {
                    int pay = food.getPrice() * 2;
                    customer.buy(pay);
                    convenienceStore.setMoney(convenienceStore.getMoney() + pay);
                    System.out.printf("[%s]> [SUCCESS] 成功出售商品, 获得金钱%d!\n", shopKeeper.getName(), pay);
                    customerList.remove(customer);
                    foodList.remove(food);
                } else {
                    System.out.printf("[%s]> [ERROR] 仓库内的%s不足!\n", shopKeeper.getName(), info);
                }
            }
        }

    }


    /** ================================================================================= 菜单4【查看顾客】 START */
    /** ================================================================================= 菜单6【查看留言板】 START */
    //6. 查看留言板
    public static void showMessageInfo() {
        shopKeeper.addMediator(messageBoard);
        showMessageInfoBlackBoard();
        System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
        String command = "";
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "1":
                    replyMessageBoard();
                    break;
                case "2":
                    messageBoard.clean();
                    break;
                case "q":
                    return;
                default:
                    System.out.printf("[%s]> [ERROR] 指令不存在!\n", shopKeeper.getName());
                    break;

            }
            showMessageInfoBlackBoard();
            System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }
    }

    //6. 查看留言板展板
    public static void showMessageInfoBlackBoard() {
        messageBoard.showMessages();
        System.out.println("* ============================================= *");
        System.out.println("@=                   1. 回复                    =@");
        System.out.println("@=                   2. 清空                    =@");
        System.out.println("@=                   q. 返回                    =@");
        System.out.println("* ============================================= *");
    }

    //6.1 回复留言板
    public static void replyMessageBoard() {
        String message = "";
        System.out.printf("[%s]> 请输入您要回复的内容: ", shopKeeper.getName());
        scanner.nextLine();
        message = scanner.nextLine();

        shopKeeper.sendMessage(message);
    }
    /** ================================================================================= 菜单6【查看留言板】 E N D */

    /** ================================================================================= 菜单3【进购食品】 START */
    //3. 进购食品
    public static void showBuyFoodInfo() {
        showBuyFoodBlackBoard();
        System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
        String command = "";
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "1":
                    showSupplyFoodList();
                    break;
                case "2":
                    showSupplyFoodListByFactoryName("A工厂");
                    break;
                case "3":
                    showSupplyFoodListByFactoryName("B工厂");
                    break;
                case "4":
                    stockFood();
                    break;
                case "q":
                    return;
                default:
                    System.out.printf("[%s]> [ERROR] 指令不存在!\n", shopKeeper.getName());
                    break;
            }
            showBuyFoodBlackBoard();
            System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }
    }

    //3. 进购食品展板
    public static void showBuyFoodBlackBoard() {
        System.out.println("* ============================================= *");
        System.out.println("@=                   1. 全部供货单               =@");
        System.out.println("@=                   2. A工厂供货单              =@");
        System.out.println("@=                   3. B工厂供货单              =@");
        System.out.println("@=                   4.  进购食品                =@");
        System.out.println("@=                   q.  返   回                =@");
        System.out.println("* ============================================= *");
    }

    //3.1.全部供货单
    public static void showSupplyFoodList() {
        for (int i = 0; i < foodPrototypeList.size(); i++) {
            Food food = foodPrototypeList.get(i);
            System.out.printf("名称: %s\t类型: %s\t生产方: %s\t价格: %d元\t[%2d]\n", food.getName(), food.getType(), food.getPlace(), food.getPrice(), i);
        }
    }

    //3.2/3 A工厂/B工厂供货单
    public static void showSupplyFoodListByFactoryName(String factoryName) {
        Specification spec;
        spec = new ProductBy(factoryName);
        for (int i = 0; i < foodPrototypeList.size(); i++) {
            Food food = foodPrototypeList.get(i);
            if (spec.isSatisfiedBy(food)) {
                System.out.printf("名称: %s\t类型: %s\t生产方: %s\t价格: %d元\t[%2d]\n", food.getName(), food.getType(), food.getPlace(), food.getPrice(), i);
            }
        }
    }

    //3.4 进购食品
    public static void stockFood() {
        System.out.printf("[%s]> 请输入您要购买的食品编号: ", shopKeeper.getName());
        int foodIndex = -1;
        if (scanner.hasNext()) {
            foodIndex = Integer.parseInt(scanner.next());
        }
        System.out.printf("[%s]> 请输入您要购买的数目: ", shopKeeper.getName());
        int foodNum = -1;
        if (scanner.hasNext()) {
            foodNum = Integer.parseInt(scanner.next());
        }
        if (foodIndex > foodPrototypeList.size() || foodIndex < 0) {
            System.out.printf("[%s]> [ERROR] 该编号的食品不存在!\n", shopKeeper.getName());
            return;
        }
        if (foodNum <= 0) {
            System.out.printf("[%s]> [ERROR] 食品购买数目不合法!\n", shopKeeper.getName());
            return;
        }
        int sum = foodPrototypeList.get(foodIndex).getPrice() * foodNum;
        if (sum > convenienceStore.getMoney()) {
            System.out.printf("[%s]> [ERROR] 店铺余额不足!\n", shopKeeper.getName());
            return;
        } else {
            convenienceStore.setMoney(convenienceStore.getMoney() - sum);
            Food food = foodPrototypeList.get(foodIndex);
            for (int i = 0; i < foodNum; i++) {
                Food f = food.createClone();
                foodRepository.addFood(f);
            }
            worldClock.refreshObserverSet(foodRepository.getFoodList());
            System.out.printf("[%s]> [SUCCESS] 购买%s[%s]成功，共花费了%d元.\n", shopKeeper.getName(), food.getName(), food.getPlace(), sum);
        }
    }
    /** ================================================================================= 菜单3【进购食品】 E N D */

    /** ================================================================================= 菜单2【查看仓库】 START */
    //2. 查看仓库
    public static void showRepositoryInfo() {
        showRepositoryInfoBlackBoard();
        String command = "";
        System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "1":
                    showBriefRepositoryInfo();
                    break;
                case "2":
                    showDetailedRepositoryInfo();
                    break;
                case "3":
                    deleteExpiredFood();
                    break;
                case "q":
                    return;
                default:
                    System.out.printf("[%s]> [ERROR] 指令不存在!\n", shopKeeper.getName());
                    break;
            }
            showRepositoryInfoBlackBoard();
            System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }
    }

    //2. 查看仓库展板
    public static void showRepositoryInfoBlackBoard() {
        System.out.println("* ============================================= *");
        System.out.println("@=                   1. 查看简要库存             =@");
        System.out.println("@=                   2. 查看详细库存             =@");
        System.out.println("@=                   3. 删除过期食品             =@");
        System.out.println("@=                   q.   返   回               =@");
        System.out.println("* ============================================= *");
    }

    //2.1 查看详细库存
    public static void showDetailedRepositoryInfo() {
        if (foodRepository.getCurrentSize() == 0) {
            System.out.printf("[%s]> [WARNING] 店铺无库存食品!\n", shopKeeper.getName());
        } else {
            foodRepository.show();
        }
    }

    //2.2 查看简要库存
    public static void showBriefRepositoryInfo() {
        Map<String, Integer> map = foodRepository.getFoodItemNumMap();
        System.out.println("*--------------------店铺库存--------------------*");
        System.out.printf("| 店铺库存饮品:\t%d个\n", map.get("饮品"));
        System.out.printf("| 店铺库存零食:\t%d个\n", map.get("零食"));
        System.out.printf("| 店铺库存糕点:\t%d个\n", map.get("糕点"));
        System.out.println("*-----------------------------------------------*");
    }

    //2.3 删除过期食品
    public static void deleteExpiredFood() {
        if (foodRepository.getCurrentSize() == 0) {
            System.out.printf("[%s]> [WARNING] 店铺无库存食品!\n", shopKeeper.getName());
        } else {
            foodRepository.deleteExpiredFood();
            System.out.printf("[%s]> [SUCCESS] 删除过期食品成功!\n", shopKeeper.getName());
        }
    }
    /** ================================================================================= 菜单2【查看仓库】 E N D */


    /** ================================================================================= 菜单1【设置店铺】 START */

    //1. 设置店铺
    public static void showStoreInfo() {
        System.out.println("* -------------------店铺信息--------------------*");
        System.out.printf("|   季节 :   \t%s\n", worldClock.getSeason());
        System.out.printf("| 世界时钟:   \t第%d天\n", worldClock.getDay());
        System.out.printf("| 店铺名称:   \t%s\n", convenienceStore.getName());
        System.out.printf("| 店长昵称:   \t%s\n", shopKeeper.getName());
        System.out.printf("| 店铺资金:   \t%s元\n", convenienceStore.getMoney());
        Map<String, Integer> map = foodRepository.getFoodItemNumMap();
        System.out.println("*--------------------店铺库存--------------------*");
        System.out.printf("| 店铺库存饮品:\t%d个\n", map.get("饮品"));
        System.out.printf("| 店铺库存零食:\t%d个\n", map.get("零食"));
        System.out.printf("| 店铺库存糕点:\t%d个\n", map.get("糕点"));
        System.out.println("*--------------------店铺装潢--------------------*");
        convenienceStore.showStoreHouseType();
        System.out.println("* ----------------------------------------------*");
        showStoreInfoBlackBoard();
        System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
        String command = "";
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "1":
                    System.out.printf("[%s]> 请输入店铺名称: ", shopKeeper.getName());
                    if (scanner.hasNext()) {
                        String storeName = scanner.next();
                        convenienceStore.setName(storeName);
                    }
                    break;
                case "2":
                    System.out.printf("[%s]> 请输入店长名称: ", shopKeeper.getName());
                    if (scanner.hasNext()) {
                        String name = scanner.next();
                        shopKeeper.setName(name);
                    }
                    break;
                case "3":
                    setStoreDecorationStyleSuite();
                    break;
                case "q":
                    return;
                default:
                    System.out.printf("[%s]> [ERROR] 指令不存在!\n", shopKeeper.getName());
                    break;
            }
            showStoreInfoBlackBoard();
            System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }
    }

    //1. 设置店铺展板
    public static void showStoreInfoBlackBoard() {
        System.out.println("* ============================================= *");
        System.out.println("@=                   1. 设置店铺名称             =@");
        System.out.println("@=                   2. 设置店长昵称             =@");
        System.out.println("@=                   3. 选择店铺装潢             =@");
        System.out.println("@=                   q.   返   回               =@");
        System.out.println("* ============================================= *");
    }

    //1.1.3 设置店铺装潢
    public static void setStoreDecorationStyleSuite() {
        showStoreDecorationStyleSuite();
        int mapleStyle = 300;
        int childStyle = 600;
        System.out.printf("[%s]> 请选择风格: ", shopKeeper.getName());
        String command = "";
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "1":
                    if (convenienceStore.getMoney() >= mapleStyle) {
                        convenienceStore.setStoreHouseType("枫木门", "抛光砖", "壁灯", "枫木货架", "清新实木招牌", "米白色枫叶窗", "格纹窗帘");
                        convenienceStore.setMoney(convenienceStore.getMoney() - mapleStyle);
                        System.out.printf("[%s]> 店铺风格更该成功!\n", shopKeeper.getName());
                    } else {
                        System.out.printf("[%s]> [ERROR] 您的余额不足!\n", shopKeeper.getName());
                    }
                    break;
                case "2":
                    if (convenienceStore.getMoney() >= childStyle) {
                        convenienceStore.setStoreHouseType("童趣乐园大门", "鹅卵石地砖", "星星壁灯", "童趣风黄色货架", "童趣乐园招牌", "饼干风拼色玻璃窗", "3色窗帘");
                        convenienceStore.setMoney(convenienceStore.getMoney() - childStyle);
                        System.out.printf("[%s]> 店铺风格更该成功!\n", shopKeeper.getName());
                    } else {
                        System.out.printf("[%s]> [ERROR] 您的余额不足!\n", shopKeeper.getName());
                    }
                    break;
                case "q":
                    return;
                default:
                    System.out.printf("[%s]> [ERROR] 指令不存在!\n", shopKeeper.getName());
                    break;
            }
            System.out.println("*-----------------------------------------------*");
            System.out.println("@=               1. 设置为枫木风格               =@");
            System.out.println("@=               2. 设置为童趣风格               =@");
            System.out.println("@=               q.   返   回                   =@");
            System.out.println("*-----------------------------------------------*");
            System.out.printf("[%s]> 请选择要进行的操作: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }
    }

    //1.1.3 店铺装潢展板
    public static void showStoreDecorationStyleSuite() {
        System.out.println("*--------------------枫木风格--------------------*");
        System.out.println("|                店门类型: 枫木门");
        System.out.println("|                窗户类型: 米白色枫叶窗");
        System.out.println("|                窗帘类型: 格纹窗帘");
        System.out.println("|                地板类型: 抛光砖");
        System.out.println("|                灯光类型: 壁灯");
        System.out.println("|                货架类型: 枫木货架");
        System.out.println("|                招牌类型: 清新实木招牌");
        System.out.println("|");
        System.out.println("|                售价   : 300元");
        System.out.println("*--------------------童趣风格--------------------*");
        System.out.println("|                店门类型: 童趣乐园大门");
        System.out.println("|                窗户类型: 饼干风拼色玻璃窗");
        System.out.println("|                窗帘类型: 3色窗帘");
        System.out.println("|                地板类型: 鹅卵石地砖");
        System.out.println("|                灯光类型: 星星壁灯");
        System.out.println("|                货架类型: 童趣风黄色货架");
        System.out.println("|                招牌类型: 童趣乐园招牌");
        System.out.println("|");
        System.out.println("|                售价   : 600元");
        System.out.println("*-----------------------------------------------*");
        System.out.println("@=               1. 设置为枫木风格               =@");
        System.out.println("@=               2. 设置为童趣风格               =@");
        System.out.println("@=               q.   返   回                   =@");
        System.out.println("*-----------------------------------------------*");
    }

    /** ================================================================================= 菜单1【设置店铺】 E N D */


    //pre: 初始化食物供货原型列表
    public static void initFoodPrototypeList() {
        foodPrototypeList = new ArrayList<>();
        Set<String> nameSet = ConstantTable.FOOD_ITEM_TYPE_MAP.keySet();
        FoodProxyA foodProxyA = new FoodProxyA(FoodFactoryA.getInstance());
        AbstractFactory foodFactoryB = FoodFactoryB.getInstance();
        for (String key : nameSet) {
            Food foodByA = foodProxyA.createFood(key);
            Food foodByB = foodFactoryB.createFood(key);
            foodPrototypeList.add(foodByA);
            foodPrototypeList.add(foodByB);
        }
    }
}

