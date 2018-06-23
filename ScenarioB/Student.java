/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofline2B;



class Student implements IObserver {

    @Override
    public void update(String i) {
        System.out.println("Student: myValue in Subject is now: " + i);
    }
}