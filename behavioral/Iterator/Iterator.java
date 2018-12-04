interface Iterator{
    Object First();
    Object Next();
    boolean IsDone();
    Object CurrentItem();
}

abstract class Aggregate{
    abstract Iterator CreateIterator();
}

class ConcreteIterator implements Iterator{
    private List<Object> list = new ArrayList<Object>();
    private int curr=0;
    public ConcreteIterator(List<Object> list){
        this.list = list;
    }

    public Object First(){
        return list.get(0);
    }

    public Object Next(){
        Object ret = null;
        curr++;
        if(curr < list.size()){
            ret = list.get(curr);
        }
        return ret;
    }

    public boolean IsDone(){
        return curr>=list.size()?true:false;
    }

    public Object CurrentItem(){
        return list.get(curr);
    }
}

class ConcreteAggregate extends Aggregate{
    private List<Object> list = new ArrayList<Object>();
    public ConcreteAggregate(List<Object> list){
        this.list = list;
    }
    public Iterator CreateIterator(){
        return new ConcreteIterator(list);
    }
}

class client{
    public static void main(String[] args){
    List<Object> list = new ArrayList<Object>();
    list.add("miner");
    list.add("any");
    Aggregate agg = new ConcreteAggregate(list);
    Iterator iterator = agg.CreateIterator();
    iterator.First();
    while(!iterator.IsDone()){
        System.out.println(iterator.CurrentItem());
        iterator.Next();
        }
    }
}