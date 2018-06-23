/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofline2B;



class ClassRepresentative implements IObserver {

    private String inform;

    private Software s;

    ClassRepresentative(Software s) {
        this.s = s;
    }

    public void informOthers(String i) {
        s.setMyValue(i);
    }

    @Override
    public void update(String i) {
        System.out.println("ClassRepresentative: observes ->myValue is changed in Subject to :" + i);
    }
}