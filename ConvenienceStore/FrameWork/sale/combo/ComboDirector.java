package sale.combo;

import utils.info.ConstantTable;

/**
 * @className: ComboDirector
 * @author: Shidan Cheng
 * @description: 套餐 具体Director类
 * @designPattern: Builder
 * @date: 7:51 上午 2019/10/22
 */
public class ComboDirector {
    private ComboBuilder comboBuilder;

    public ComboDirector(ComboBuilder comboBuilder) {
        this.comboBuilder = comboBuilder;
        this.makeFoodCombo();
    }

    private void makeFoodCombo() {
        comboBuilder.makeCombo();


        if (ConstantTable.TEST_PROGRAM) {
            //以下部分仅供测试输出使用
            int price = comboBuilder.getComboPrice();
            int reduce = comboBuilder.getReducedPrice();
            System.out.printf(">>> 套餐价格: %d[%d - %d]元\n", price, (int) (price + reduce), reduce);
        }
    }


    public int getComboPrice(){
        return comboBuilder.getComboPrice();
    }




    /**
     * 获取制作的食品套餐
     *
     * @methodName: getFoodCombo
     * @param: []
     * @return: sale.combo.FoodCombo
     */
    public FoodCombo getFoodCombo() {
        return comboBuilder.getFoodCombo();
    }

}