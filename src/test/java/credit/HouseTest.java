package credit;

import credit.entity.House;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HouseTest {

    @Test
    public void testTaxAmount(){

        int amount = 450000;
        int hoa = 300;
        double homeTax = 0.1;
        int monthlyInsurance = 120;
        House house = new House(amount, hoa, homeTax, monthlyInsurance);
        double monthlyTax = (amount*homeTax/100)/12;

        Assertions.assertEquals(monthlyTax, house.getMonthlyTax());
    }

    @Test
    public void test(){

        int amount = 450000;
        int hoa = 300;
        double homeTax = 0.1;
        int monthlyInsurance = 120;
        House house = new House(amount, hoa, homeTax, monthlyInsurance);
        double monthlyTax = house.getMonthlyTax();

        Assertions.assertEquals(hoa+monthlyInsurance+monthlyTax, house.calculateExpenses());
    }

}
