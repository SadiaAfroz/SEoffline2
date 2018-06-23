/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offline2A;

/**
 *
 * @author Faiza
 */
  class VendMachine {
	
	FunctionalityOfState prod_no_change;     
	FunctionalityOfState prod_change;
	FunctionalityOfState no_pro_insufficientCurrency;
	FunctionalityOfState no_pro_depletion;
	
	FunctionalityOfState CurrentState;
	int ret=0;
	int cashInMachine = 100;
        public VendMachine(){
		
		prod_no_change = new Prod_no_change(this);
		prod_change = new Prod_change(this);
		no_pro_insufficientCurrency = new NoProinsufficientCurrency(this);
		no_pro_depletion = new NoProDepletion(this);
		
		CurrentState = prod_no_change ;
		
		if(cashInMachine == 0 ){
			
			CurrentState = prod_no_change;
			
		}
		
                
	}
        void setVState(FunctionalityOfState newVState){
		//System.out.println("in state   "+newVState);
		CurrentState = newVState;
        }
	
	public void setCashInMachine(int newCashInMachine){
		
		cashInMachine = newCashInMachine;
		
	}
         public void InsertCoin(int amount) {
             ret=amount-10;
             if(ret<0)
                 ret=amount;
            else if(cashInMachine<ret)
                 ret=amount;
             if(amount==10) ret=0;
             else if(amount>10 && cashInMachine<(amount-10) ){
                ret=amount;
            }
             else if(amount<10){
                 ret=amount;
             }
             else{
               ret=cashInMachine-10;
             }
            
  
           CurrentState.InsertCoin(amount);
          // ret=amount-10;
           //cashInMachine=cashInMachine+10;
  
           
         
         }
        public void SelectDrink(String name) {
           
           CurrentState.SelectDrink(name);
    }
        public int GetReturn() {
           CurrentState.GetReturn();
           return ret;
    }
         public void GetDrink() {
         CurrentState.GetDrink();
        
    }
   
       public FunctionalityOfState no_ret() { return prod_no_change; }
       public FunctionalityOfState yes_ret() { return prod_change; }
       public FunctionalityOfState no_prod() { return no_pro_insufficientCurrency; }
       public FunctionalityOfState no_money() { return no_pro_depletion; }
       
	
	
	}
	
	
