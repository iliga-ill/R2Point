public class Deq {
    private final static int DEFSIZE = 16;
    static R2Point[] array;
    public int[] arrayR;
    public int size, head, tail, T;

    private int forward(int index) {
        //System.out.println("forward(index= " + index + " )");
       // System.out.println("forward->return (++index < array.length ? index : 0)= "+ (++index < array.length ? index : 0)+" ;");
        return ++index < array.length ? index : 0;
    }

    private int backward(int index) {
        //System.out.println("backward(index= " + index + " )");
       //System.out.println("backward->return (--index >= 0 ? index : array.length - 1;)= "+ (--index >= 0 ? index : array.length - 1)+" ;");
        return --index >= 0 ? index : array.length - 1;
    }

    public Deq(int size) {
        //System.out.println("Deq(size= " + size + " )");
        array = new R2Point[size];
        arrayR = new int[4];
        for(int i=0;i<4;i++){arrayR[i]=0;}
       // System.out.println("Deq->array = new R2Point[size= "+size+" ];");
        this.size = head = 0;
        //System.out.println("Deq->this.size = head = 0;");
        tail = array.length - 1;
        //System.out.println("Deq->tail = array.length= "+array.length+" - 1;");
    }
    public Deq() {
    this(DEFSIZE);
    //System.out.println("Deq()");
    //System.out.println("Deq->this(DEFSIZE= "+DEFSIZE+" );");
    }
    public int length() {
        //System.out.println("length()");
        //System.out.println("length->return: " + size);
        return size;
    }
    public void pushFront(R2Point p) {
        //System.out.println("pushFront(R2Point p= "+p+" )");
        //System.out.println("pushFront->array[head=backward(head= "+head+")] = p= "+p+" ;----");
        array[head=backward(head)] = p;
        //System.out.println("----pushFront->array[head= "+head+" ] = "+p+" ;");
        //System.out.println("pushFront->size= "+size+" +1");
        size += 1;
    }
    public void pushBack(R2Point p) {
        //System.out.println("pushBack(R2Point p= "+p+" )");
        //System.out.println("pushBack->array[tail=forward(tail= "+tail+" )] = p;----");
        array[tail=forward(tail)] = p;
        //System.out.println("----array[tail= "+tail+" ] = "+p+" ) end");
        //System.out.println("pushBack->size= "+size+" +1");
        size += 1;
    }
    public R2Point popFront() {
        //System.out.println("popFront()");
        //System.out.println("popFront->R2Point p = front();----");
        R2Point p = front();
        //System.out.println("----R2Point p= "+p+" = front(); end");
        //System.out.println("popFront->head = forward(head= "+head+" );----");
        head = forward(head);
        //System.out.println("----head = "+head+" ; end");
        //System.out.println("popFront->size= "+size+" -1");
        size -= 1;
        //System.out.println("popFront->return p= "+p+" ;");
        return p;
    }
    public R2Point popBack() {
        //System.out.println("popBack()");
        //System.out.println("popBack->R2Point p = back();----");
        R2Point p = back();
        //System.out.println("----R2Point p= "+p+" = back(); end");
       //System.out.println("popBack->tail = backward(tail= "+tail+" );----");
        tail = backward(tail);
        //System.out.println("----tail = "+tail+" ; end");
        //System.out.println("popBack->size= "+size+" -1");
        size -= 1;
        //System.out.println("popBack->return p= "+p+" ;");
        return p;
    }
    public R2Point front() {
        //System.out.println("front()");
        //System.out.println("front->return array[head= "+head+" ];");
        return array[head];
    }
    public R2Point back() {
        //System.out.println("back()");
        //System.out.println("back->return array[tail= "+tail+" ];");
        return array[tail];
    }
    public boolean GetT(){
        T=0;
        for(int i=0;i<4;i++){T+=arrayR[i];}
        if (T>0) { return true;}
        else{return false;}
    }
}
