/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline2A;



public class Offline2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VendMachine vMachine = new VendMachine();
        vMachine.InsertCoin(18);
        vMachine.SelectDrink("mirinda");
        vMachine.GetReturn();
        vMachine.GetDrink();
            vMachine.InsertCoin(8);
        vMachine.SelectDrink("Pepsi");
        vMachine.GetReturn();
        vMachine.GetDrink();
        
		
    }
    
}
