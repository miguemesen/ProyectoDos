class Node {
    constructor(data, back=null, front=null) {
        this.data=data;
        this.back=back;
        this.front=front;
    }
}
class LinkedList {
    constructor() {
        this.head=null;
        this.tail=null;
        this.len=0;
    }
    add(data){
        if(data==null)return;
        if(this.head==null){
            this.head=this.tail=new Node(data);

        }
        else {
            var node=new Node(data)
            node.back=this.tail;
            this.tail.front=node;
            this.tail=node;
        }
        this.len++;
    }
    deletePos(index){
        var temp=this.getNode(index);
        if(temp==null)return;
        temp.back.front=temp.front;
        temp.front.back=temp.back;
        this.len--;
    }
    get(index){
        var temp=this.getNode(index);
        if(temp==null)return;
        return temp.data;

    }
    verification(index){
        if(!index instanceof Number) return false;
        if(!Number.isInteger(index))return false;
        if(index<0 || index>=this.len)return false;
        return true;
    }
    getNode(index){
        if(!this.verification(index))return null;
        var i;
        var temp=this.head;
        for(i=0;i!=index;i++){
            temp=temp.front;
        }
        return temp;
    }

}
//export default Node;
//export default LinkedList;