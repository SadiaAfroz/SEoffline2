/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofline2B;

interface ISoftware {

    void subscribe(IObserver o);

    void unsubscribe(IObserver o);

    void notifyObservers(String i);
}