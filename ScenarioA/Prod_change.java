/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline2A;



class Prod_change implements FunctionalityOfState  {
    
    VendMachine vMachine;
	
	public Prod_change(VendMachine newVMachine){
		
		vMachine = newVMachine;
		
	}


    @Override
    public void InsertCoin(int amount) {
        System.out.println("Coin inserted is "+amount);
            int i=vMachine.cashInMachine;
         if (amount<10)
         {
             vMachine.setVState(vMachine.no_prod());
             return;
         }
         else if(amount>10 && (i-10)<=0)
         {
          vMachine.setVState(vMachine.no_money());  
           return;
         }
             
         else if(amount==10)
         {
          vMachine.setVState(vMachine.no_ret());
           return;
         }
        
        
    }

    @Override
    public void SelectDrink(String name) {
        System.out.println(name+" is ordered");
    }

    @Override
    public int GetReturn() {
        int i=vMachine.ret;
        System.out.println("Money "+i+" is returned");
        return i;
                
        
    }

    @Override
    public void GetDrink() {
        System.out.println("Drink is given");
        vMachine.cashInMachine+=10;
    }
    
}