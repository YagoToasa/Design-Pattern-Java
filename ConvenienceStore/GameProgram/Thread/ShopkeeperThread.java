package GameProgram.Thread;

import cards.CardFactory;
import cards.MembershipCard;
import cards.OrdinaryCardFactory;
import cards.SeniorCardFactory;
import coupons.*;
import factory.AbstractFactory;
import factory.FoodFactoryA;
import factory.FoodFactoryB;
import foods.*;
import foods.lookup.ProductBy;
import foods.lookup.base.Specification;
import person.Customer;
import person.*;
import person.Person;
import person.IsPerson;
import person.PersonFactory;
import person.ShopAssistant;
import sale.combo.AComboBuilder;
import sale.combo.BComboBuilder;
import sale.combo.ComboBuilder;
import sale.combo.ComboDirector;
import store.summary.StoreDailySummary;
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
    static private StoreDailySummary storeDailySummary= new StoreDailySummary();
    static private int couponSum = 0;

    @Override
    public void run() {
        storeDailySummary.storeDailySummary();
        initFoodPrototypeList();
        initShopAssistant();
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
                    hiringAdditionalStaff();
                    break;
                case "6":
                    showMakeCouponsInfo();
                    break;
                case "7":
                    showMessageInfo();
                    break;
                case "8":
                    showSecuritySystem();
                    break;
                case "9":
                    System.out.printf("[%s]> [CLOSE] 关闭所有器械的电源!\n", shopKeeper.getName());
                    storeDailySummary.shutDownAll();
                    System.out.printf("[%s]> [CLOSE] 进行大扫除!\n", shopKeeper.getName());
                    worldClock.updateTheWorld();
                    getShopAssistantOutput();
                    System.out.printf("[%s]> [OPEN] 检查所有器械!\n", shopKeeper.getName());
                    storeDailySummary.checkUpAll();
                    System.out.printf("[%s]> [OPEN] 开启所有器械的电源!\n", shopKeeper.getName());
                    storeDailySummary.startUpAll();
                    break;
                case "10":
                    cheatMode();
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
        System.out.println("* ============================================== *");
        System.out.printf("                     %5s                         \n", convenienceStore.getName());
        System.out.printf("                     第%d天                       \n", worldClock.getDay());
        System.out.printf("                     季节: %s                    \n", worldClock.getSeason());
        System.out.printf("                     人气值: %s                    \n", couponSum);
        System.out.println("* ============================================== *");
        System.out.println("@=                   1. 设置店铺                 =@");
        System.out.println("@=                   2. 查看仓库                 =@");
        System.out.println("@=                   3. 进购食品                 =@");
        System.out.println("@=                   4. 查看顾客                 =@");
        System.out.println("@=                   5. 招聘店员                 =@");
        System.out.println("@=                   6. 制作优惠券[提升人气值]     =@");
        System.out.println("@=                   7. 查看留言板               =@");
        System.out.println("@=                   8. 安保系统                 =@");
        System.out.println("@=                   9. 结束本天                 =@");
        System.out.println("@=                   q. 结束游戏                 =@");
        System.out.println("* ============================================== *");
    }

    /** ================================================================================= 菜单8【安保系统】 START */
    //8. 安保系统
    public void showSecuritySystem(){

        PersonFactory personFactory = new PersonFactory();

        System.out.println("*------------------查看安保系统------------------*");

        for (int i = 0; i < customerList.size(); i++) {
            //加入顾客
            VisitorsMap.put(customerList.get(i).getName(), "Customer");
        }

        for (int i = 0; i < shopAssistantList.size(); i++) {
            //加入被雇佣的店员
            if (hiredShopAssistant.contains(shopAssistantList.get(i))){
                VisitorsMap.put(shopAssistantList.get(i).getName(), "ShopAssistant");
            }
        }

        for(Map.Entry<String, String> entry: VisitorsMap.entrySet())
        {
            IsPerson nperson= personFactory.getPerson(entry.getKey(),entry.getValue());
            if(entry.getValue()=="Customer"){
                System.out.println("| 一位叫做"+entry.getKey()+"的顾客前来购物——");
            }
            else if(entry.getValue()=="ShopAssistant"){
                System.out.println("| 一位叫做"+entry.getKey()+"的店员前来上班——");
            }
            else {
                //VisitorsMap事先存放了几种不合法人士的类型
                System.out.println("| 一位不合法人士来访——");
                System.out.println("| 姓名: "+ entry.getKey()+ " 类型: "+entry.getValue());
            }
            nperson.showPerson();
            System.out.println("***");
        }
        System.out.println("*-----------------------------------------------*");

    }
    /** ================================================================================= 菜单5【招聘店员】 START */
    //5. 招聘店员
    public void hiringAdditionalStaff(){
        hiringAdditionalStaffBlackBoard();
        System.out.printf("[%s]> 请选择您要招募的店员: ", shopKeeper.getName());
        String command = "";
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "0":
                case "1":
                case "2":
                    hireStaff(Integer.parseInt(command));
                    break;
                case "q":
                    return;
                default:
                    System.out.printf("[%s]> [ERROR] 店员不存在!\n", shopKeeper.getName());
                    break;
            }
            hiringAdditionalStaffBlackBoard();
            System.out.printf("[%s]> 请选择您要招募的店员: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }
    }
    //5. 招聘店员
    public void hireStaff(int index){
        if (index >= shopAssistantList.size() || index < 0) {
            System.out.printf("[%s]> [ERROR] 店员不存在!\n", shopKeeper.getName());
        }else{
            ShopAssistant shopAssistant = shopAssistantList.get(index);
            if (hiredShopAssistant.contains(shopAssistant)){
                System.out.printf("[%s]> [ERROR] 店员已被招募过!\n", shopKeeper.getName());
            }else{
                hiredShopAssistant.add(shopAssistant);
                if (shopAssistant.getDuty().equals("制作咖啡")){
                    convenienceStore.setMoney(convenienceStore.getMoney() - 500);
                }else if (shopAssistant.getDuty().equals("制作冰淇淋")){
                    convenienceStore.setMoney(convenienceStore.getMoney() - 300);
                } else {
                    convenienceStore.setMoney(convenienceStore.getMoney() - 200);
                }
                System.out.printf("[%s]> [SUCCESS] 店员招募成功!\n", shopKeeper.getName());
            }
        }

    }

    //5. 招聘店员展板
    public void hiringAdditionalStaffBlackBoard(){
        System.out.println("* -------------------店员列表--------------------*");
        for (int i = 0; i < shopAssistantList.size(); i++) {
            System.out.printf("|-店员编号:\t%d\n", i);
            System.out.printf("| 店员姓名:\t%s\n", shopAssistantList.get(i).getName());
            String duty = shopAssistantList.get(i).getDuty();
            System.out.printf("| 店员技能:\t%s\n", duty);
            String effect = "";
            int cost = 0;
            if (duty.equals("制作咖啡")){
                effect = "每天赚取100元";
                cost = 500;
            } else if (duty.equals("制作冰淇淋")){
                effect = "每天赚取50元";
                cost = 300;
            } else {
                effect = "每天赚取25元";
                cost = 200;
            }
            System.out.printf("| 店员效果:\t%s\n", effect);
            System.out.printf("| 招聘价格:\t%d\n", cost);
            if (hiredShopAssistant.contains(shopAssistantList.get(i))){
                System.out.printf("| 是否已招聘:\t是\n");
            }else{
                System.out.printf("| 是否已招聘:\t否\n");
            }
            System.out.println("|");
        }
        System.out.println("* ----------------------------------------------*");
        System.out.println("* ============================================= *");
        System.out.println("@=              请选择店员编号进行招募            =@");
        System.out.println("@=                   q. 返回                    =@");
        System.out.println("* ============================================= *");
    }

    //5. 获取店员盈利
    public void getShopAssistantOutput(){
        for (int i = 0; i < hiredShopAssistant.size(); i++){
            ShopAssistant shopAssistant = (ShopAssistant) hiredShopAssistant.get(i);
            String duty = shopAssistant.getDuty();
            int outPut = 0;
            if (duty.equals("制作咖啡")){
                outPut = 100;
            } else if (duty.equals("制作冰淇淋")){
                outPut = 50;
            } else {
                outPut = 25;
            }
            convenienceStore.setMoney(convenienceStore.getMoney() + outPut);
        }
    }
    /** ================================================================================= 菜单5【招聘店员】 E N D */
    /** ================================================================================= 菜单6【制作优惠券】 START */
    //6. 制作优惠券
    public static void showMakeCouponsInfo(){
        Discount discount30off = new DiscountRateThree();
        Discount discount50off = new DiscountRateFive();
        Discount discount70off = new DiscountRateSeven();
        Coupon drinksCoupon = null;
        Coupon snacksCoupon = null;
        Coupon pastryCoupon = null;

        showMakeCouponsInfoBlackBoard();
        System.out.printf("[%s]> 请选择您要进行的操作: ", shopKeeper.getName());
        String command = "";
        if (scanner.hasNext()) {
            command = scanner.next();
        }
        while (!command.equals("")) {
            switch (command) {
                case "1":
                    drinksCoupon= new DrinksCoupon(discount30off);
                    drinksCoupon.discribeCouponInfo();
                    couponSum +=30;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 2);
                    break;
                case "2":
                    drinksCoupon= new DrinksCoupon(discount50off);
                    drinksCoupon.discribeCouponInfo();
                    couponSum +=50;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 3);
                    break;
                case "3":
                    drinksCoupon= new DrinksCoupon(discount70off);
                    drinksCoupon.discribeCouponInfo();
                    couponSum +=70;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 5);
                    break;
                case "4":
                    pastryCoupon = new PastryCoupon(discount30off);
                    pastryCoupon.discribeCouponInfo();
                    couponSum +=30;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 2);
                    break;
                case "5":
                    pastryCoupon = new PastryCoupon(discount50off);
                    pastryCoupon.discribeCouponInfo();
                    couponSum +=50;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 3);
                    break;
                case "6":
                    pastryCoupon = new PastryCoupon(discount70off);
                    pastryCoupon.discribeCouponInfo();
                    couponSum +=70;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 5);
                    break;
                case "7":
                    snacksCoupon = new SnacksCoupon(discount30off);
                    snacksCoupon.discribeCouponInfo();
                    couponSum +=30;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 2);
                    break;
                case "8":
                    snacksCoupon = new SnacksCoupon(discount50off);
                    snacksCoupon.discribeCouponInfo();
                    couponSum +=50;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 2);
                    break;
                case "9":
                    snacksCoupon = new SnacksCoupon(discount70off);
                    snacksCoupon.discribeCouponInfo();
                    couponSum +=70;
                    convenienceStore.setMoney(convenienceStore.getMoney() - 5);
                    break;
                case "q":
                    return;
                default:
                    System.out.printf("[%s]> [ERROR] 指令不存在!\n", shopKeeper.getName());
                    break;
            }
            showMakeCouponsInfoBlackBoard();
            System.out.printf("[%s]> 请选择您要进行的操作, 一次只能制作一张: ", shopKeeper.getName());
            if (scanner.hasNext()) {
                command = scanner.next();
            }
        }
    }

    //6. 制作优惠券展板
    public static void showMakeCouponsInfoBlackBoard(){

        System.out.println("* ===================== 说明 ================== *");
        System.out.printf("                当前人气值： %d\n",couponSum);
        System.out.printf("                人气值每满500, 顾客数目加1\n");
        ConstantTable.CUSTOMER_NUMBER += couponSum/500;
        System.out.printf("                当前每分钟顾客数目： %d\n",ConstantTable.CUSTOMER_NUMBER);
        System.out.println("* --------------------------------------------- *");
        System.out.println("@=             1. 饮品30%off优惠券[人气+30][$2]  =@");
        System.out.println("@=             2. 饮品50%off优惠券[人气+50][$3]  =@");
        System.out.println("@=             3. 饮品70%off优惠券[人气+70][$5]  =@");
        System.out.println("@=             4. 糕点30%off优惠券[人气+30][$2]  =@");
        System.out.println("@=             5. 糕点50%off优惠券[人气+50][$3]  =@");
        System.out.println("@=             6. 糕点70%off优惠券[人气+70][$5]  =@");
        System.out.println("@=             7. 零食30%off优惠券[人气+30][$2]  =@");
        System.out.println("@=             8. 零食50%off优惠券[人气+50][$3]  =@");
        System.out.println("@=             9. 零食70%off优惠券[人气+70][$5]  =@");
        System.out.println("@=                   q. 返回                    =@");
        System.out.println("* ============================================= *");
    }
    /** ================================================================================= 菜单6【制作优惠券】 E N D */

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
                case "1":
                case "2":
                case "3":
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
            customer.addMediator(messageBoard);
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
                    System.out.printf("该顾客已留言:");
                    customer.sendMessage(messageList.get(index));
                    System.out.println(messageList.get(index));
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

                    System.out.printf("该顾客已留言\n");
                    customer.sendMessage(messageList.get(index));
                    System.out.println(messageList.get(index));
                    customerList.remove(customer);
                }
            } else if (info.equals("办理普通会员卡")) {
                CardFactory ordinaryCardFactory = new OrdinaryCardFactory();
                MembershipCard cardOrdinary = ordinaryCardFactory.getCard(customer.getName());
                cardOrdinary.showMemberShipCard();
                customer.buy(PriceTable.ORDINARY_CARD);
                convenienceStore.setMoney(convenienceStore.getMoney() + PriceTable.ORDINARY_CARD);
                System.out.printf("[%s]> [SUCCESS] 成功办理普通会员卡, 获得金钱%d!\n", shopKeeper.getName(), PriceTable.ORDINARY_CARD);
                System.out.printf("该顾客已留言:");
                customer.sendMessage(messageList.get(index));
                System.out.println(messageList.get(index));
                customerList.remove(customer);
            } else if (info.equals("办理高级会员卡")) {
                CardFactory seniorCardFactory = new SeniorCardFactory();
                MembershipCard cardSenior = seniorCardFactory.getCard(customer.getName());
                cardSenior.showMemberShipCard();
                customer.buy(PriceTable.SENIOR_CARD);
                convenienceStore.setMoney(convenienceStore.getMoney() + PriceTable.SENIOR_CARD);
                System.out.printf("[%s]> [SUCCESS] 成功办理高级会员卡, 获得金钱%d!\n", shopKeeper.getName(), PriceTable.SENIOR_CARD);
                System.out.printf("该顾客已留言:");
                customer.sendMessage(messageList.get(index));
                System.out.println(messageList.get(index));
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
                    System.out.printf("该顾客已留言:");
                    customer.sendMessage(messageList.get(index));
                    System.out.println(messageList.get(index));
                    customerList.remove(customer);
                    foodList.remove(food);
                } else {
                    System.out.printf("[%s]> [ERROR] 仓库内的%s不足!\n", shopKeeper.getName(), info);
                }
            }
        }

    }


    /** ================================================================================= 菜单4【查看顾客】 START */
    /** ================================================================================= 菜单7【查看留言板】 START */
    //7. 查看留言板
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

    //7. 查看留言板展板
    public static void showMessageInfoBlackBoard() {
        messageBoard.showMessages();
        System.out.println("* ============================================= *");
        System.out.println("@=                   1. 回复                    =@");
        System.out.println("@=                   2. 清空                    =@");
        System.out.println("@=                   q. 返回                    =@");
        System.out.println("* ============================================= *");
    }

    //7.1 回复留言板
    public static void replyMessageBoard() {
        String message = "";
        System.out.printf("[%s]> 请输入您要回复的内容: ", shopKeeper.getName());
        scanner.nextLine();
        message = scanner.nextLine();

        shopKeeper.sendMessage(message);
    }
    /** ================================================================================= 菜单7【查看留言板】 E N D */

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
        System.out.printf("| 人 气 值:    \t%s\n", couponSum);
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

    public static void initShopAssistant(){
        shopAssistantList.add(new ShopAssistant("Jack","制作咖啡"));
        shopAssistantList.add(new ShopAssistant("Lilith","制作豆浆"));
        shopAssistantList.add(new ShopAssistant("Lilith","制作冰淇淋"));

    }

    public static void cheatMode(){
        System.out.println("* =================== Cheat Mode =============== *");
        System.out.println("@=      Σ( ° △ °|||)︴ 为什么不遵循说明书？         =@");
        System.out.println("@=                                               =@");
        System.out.println("@=               金钱调整为99999999               =@");
        System.out.println("@=                所有物品数目增加10               =@");
        System.out.println("@=          请不要滥用此功能，仅为调试BUG使用        =@");
        System.out.println("* ============================================== *");
        convenienceStore.setMoney(99999999);
        for (Food f: foodPrototypeList
             ) {
            for (int i = 0; i < 99; i++) {
                foodRepository.addFood(f.createClone());
            }

        }

    }
}

