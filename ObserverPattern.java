package ofline2B;

import java.util.ArrayList;
import java.util.List;

interface IObserver {

    void update(String s);
}

class Student implements IObserver {

    @Override
    public void update(String i) {
        System.out.println("Student: myValue in Subject is now: " + i);
    }
}

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

interface ISoftware {

    void subscribe(IObserver o);

    void unsubscribe(IObserver o);

    void notifyObservers(String i);
}

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

class ObserverPatternModifiedEx {

    public static void main(String[] args) {
        System.out.println("*** Modified Observer Pattern Demo***\n");
        Software sub = new Software();
        Student ob1 = new Student();
        ClassRepresentative ob2 = new ClassRepresentative(sub);
        sub.subscribe(ob1);
        sub.subscribe(ob2);
           String information="Class will start in 23 June :(";
        ob2.informOthers(information);
        System.out.println();
         information="SE offline have to submit within 23 June 11pm";
        ob2.informOthers(information);
        System.out.println();
//unsubscribe ob1 only
        sub.unsubscribe(ob1);
          information="Hello!!! due to World Cup auto is comming";
//Now only ob2 will observe the change
        ob2.informOthers(information);
    }
}
