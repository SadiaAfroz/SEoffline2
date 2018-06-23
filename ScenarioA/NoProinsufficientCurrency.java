/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline2A;


 class NoProinsufficientCurrency implements FunctionalityOfState  {
    
    VendMachine vMachine;
	
	public NoProinsufficientCurrency(VendMachine newVMachine){
		
		vMachine = newVMachine;
		
	}


    @Override
    public void InsertCoin(int amount) {
         System.out.println("Amount of Money Inserted is "+amount);
          int i=vMachine.cashInMachine;
           if(amount==10)
         {
          vMachine.setVState(vMachine.no_ret());
           return;
         }
           
         else if(amount>10 && (i-10)<0)
         {
          vMachine.setVState(vMachine.no_money());  
           return;
         }
             
      
         else if (amount>10)
         {
             vMachine.setVState(vMachine.yes_ret());
             return;
         }
        
         
         
    }

    @Override
    public void SelectDrink(String name) {
        System.out.println("Requested drink is "+name);
    }

    @Override
    public int GetReturn() {
        int i=vMachine.ret;
       
                
        System.out.println("Money given back is "+i);
         return i;
    }

    @Override
    public void GetDrink() {
       
        System.out.println("No Drink is given due to insufficient currency deposited");
    }
    
}
