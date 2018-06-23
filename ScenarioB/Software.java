/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofline2B;

import java.util.ArrayList;
import java.util.List;


class Software implements ISoftware {

    private String myValue;

    public String getMyValue() {
        return myValue;
    }

    public void setMyValue(String myValue) {
        this.myValue = myValue;
//Notify observers
        notifyObservers(myValue);
    }

    List<IObserver> observersList = new ArrayList<IObserver>();

    @Override
    public void subscribe(IObserver o) {
        observersList.add(o);
    }

    @Override
    public void unsubscribe(IObserver o) {
        observersList.remove(o);
    }

    @Override
    public void notifyObservers(String updatedValue) {
        for (int i = 0; i < observersList.size(); i++) {
            observersList.get(i).update(updatedValue);
        }
    }
}
