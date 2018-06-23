/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofline2B;



import java.util.ArrayList;
import java.util.List;

class Observer {
    String information;
    public void update(String str) {
        information=str;
        System.out.println("New Information is : "+information);
    }
}



class Subject implements ISubject {

    List<Observer> observerList = new ArrayList<Observer>();
    private String inform;

    public String getFlag() {
        return inform;
    }

    public void setFlag(String inform) {
        this.inform = inform;
//flag value changed .So notify observer(s)
        notifyObservers(inform);
    }

    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers(String s) {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update(s);
        }
    }

  
}

class ObserverPattern {

    public static void main(String[] args) {
        System.out.println("***CTRObserver Pattern Demo***\n");
        Observer o1 = new Observer();
        Subject sub1 = new Subject();
        sub1.register(o1);
        String information="Class will start in 23 June :(";
        System.out.println(information);
        sub1.setFlag(information);
       // System.out.println("Setting Flag = 25 ");
       information="SE offline have to submit within 23 June 11pm";
        sub1.setFlag(information);
        sub1.unregister(o1);
//No notification this time to o1 .Since it is unregistered.
        information="Hello!!! due to World Cup auto is comming";
        sub1.setFlag(information);
    }
}
