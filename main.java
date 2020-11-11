
public class main {

	public static int whichQueue() {										// hangi Queue girecek onu belirlemek için yapýldý. [1-3] (random)
		int qnumber = (int)(Math.random()*3+1);
		return qnumber;
	}
	
	public static int createdNumber() {										//	[1-5] arasý sayý üretme (random)
		int number = (int)(Math.random()*5+1);
		return number;
	}
	
	public static boolean horizontalControl(Queue o) {							// Yatay Kontrol
		int size1 = o.size();
		int a,b,c,d,e,f,g;		
		boolean flag1=false;
		
		
		if(size1==3) {
			a= (int)o.dequeue();
			b= (int)o.dequeue();					
			c= (int)o.dequeue();
			if((a+1==b && a+2==c) || (a-1==b && a-2==c)) {
				flag1=true;
			}
			o.enqueue(a);
			o.enqueue(b);
			o.enqueue(c);
		}
		else if(size1==4) {
			a= (int)o.dequeue();
			b= (int)o.dequeue();					
			c= (int)o.dequeue();
			d= (int)o.dequeue();
			if((b+1==c && b+2==d) || (b-1==c && b-2==d)) {
				flag1=true;
			}
			o.enqueue(a);
			o.enqueue(b);
			o.enqueue(c);
			o.enqueue(d);			
		}
		else if(size1==5) {
			a= (int)o.dequeue();
			b= (int)o.dequeue();					
			c= (int)o.dequeue();
			d= (int)o.dequeue();
			e= (int)o.dequeue();
			if((c+1==d && c+2==e) || (c-1==d && c-2==e)) {
				flag1=true;				
			}
			o.enqueue(a);
			o.enqueue(b);
			o.enqueue(c);
			o.enqueue(d);
			o.enqueue(e);
		}
		else if(size1==6) {
			a= (int)o.dequeue();
			b= (int)o.dequeue();					
			c= (int)o.dequeue();
			d= (int)o.dequeue();
			e= (int)o.dequeue();
			f= (int)o.dequeue();
			if((d+1==e && d+2==f) || (d-1==e && d-2==f)) {
				flag1=true;				
			}
			o.enqueue(a);
			o.enqueue(b);
			o.enqueue(c);
			o.enqueue(d);
			o.enqueue(e);
			o.enqueue(f);			
		}
		else if(size1==7) {
			a= (int)o.dequeue();
			b= (int)o.dequeue();					
			c= (int)o.dequeue();
			d= (int)o.dequeue();
			e= (int)o.dequeue();
			f= (int)o.dequeue();
			g= (int)o.dequeue();
			if((e+1==f && e+2==g) || (e-1==f && e-2==g)) {
				flag1=true;				
			}
			o.enqueue(a);
			o.enqueue(b);
			o.enqueue(c);
			o.enqueue(d);
			o.enqueue(e);
			o.enqueue(f);
			o.enqueue(g);
		}
		
		return flag1;
		
	}
	
	public static boolean verticalControl(Queue q1,Queue q2, Queue q3) {		// Dikey Kontrol
		int size1= q1.size();
		int size2= q2.size();
		int size3= q3.size();
		int smallestsize=size1;
		boolean flag=false;
		
		if(size1<size2 && size1 < size3) {											// en küçük size sahip Queue yi bulmak için yapýldý
			smallestsize= size1;
		}
		else if(size2<size1 && size2 < size3) {
			smallestsize = size2;
		}
		else if(size3<size1 && size3 < size1) {
			smallestsize = size3;
		}
		
		
		if(size1>0 && size2>0 && size3>0 ) {
			for (int i = 0; i < smallestsize; i++) {
				if((((int)q1.peek()==(int)q2.peek()+1 && (int)q1.peek()==(int)q3.peek()+2)) || ((int)q1.peek()+1==(int)q2.peek() && (int)q1.peek()+2==(int)q3.peek()))  {
					flag=true;
				}
				q1.enqueue(q1.dequeue());
				q2.enqueue(q2.dequeue());
				q3.enqueue(q3.dequeue());
			}
			for (int i = 0; i < size1-smallestsize; i++) {
				q1.enqueue(q1.dequeue());
			}
			for (int i = 0; i < size2-smallestsize; i++) {
				q2.enqueue(q2.dequeue());
			}
			for (int i = 0; i < size3-smallestsize; i++) {
				q3.enqueue(q3.dequeue());
			}
			
		}
				
		return flag;
	}
	
	public static void printQueue(Queue q) {									// Queue yazdýrma
		int size= q.size();
		
		for (int i = 0; i < size; i++) {
			System.out.print(q.peek()+" ");
			q.enqueue(q.dequeue());
		}
	}
	
	public static void Menu(String user,Queue q1,Queue q2,Queue q3) {			// Ekran görüntüsü
		System.out.println(user+":");
		System.out.print("Q1-- ");
		printQueue(q1);
		System.out.println();
		System.out.print("Q2-- ");
		printQueue(q2);
		System.out.println();
		System.out.print("Q3-- ");
		printQueue(q3);
		System.out.println();
		System.out.println();
	}
	
	public static void put(int box,Queue q1, Queue q2, Queue q3) {				// Queue sorgulama ve boþ yere koyma
		if(box==1) {
			if(q1.size()<7) {
				q1.enqueue(createdNumber());
			}
			else if(q1.size()==7 && q2.size()<7) {
				q2.enqueue(createdNumber());
			}
			else if(q1.size()==7 && q3.size()<7) {
				q3.enqueue(createdNumber());
			}																			
		}
		else if(box==2) {
			if(q2.size()<7) {
				q2.enqueue(createdNumber());
			}
			else if(q2.size()==7 && q1.size()<7) {
				q1.enqueue(createdNumber());
			}
			else if(q2.size()==7 && q3.size()<7) {
				q3.enqueue(createdNumber());
			}																			
		}
		else if(box==3) {
			if(q3.size()<7) {
				q3.enqueue(createdNumber());
			}
			else if(q3.size()==7 && q2.size()<7) {
				q2.enqueue(createdNumber());
			}
			else if(q3.size()==7 && q1.size()<7) {
				q1.enqueue(createdNumber());
			}																			
		}
	}
	
	public static void main(String[] args) {
		
		Queue q1 = new Queue(840);
		Queue q2 = new Queue(840);
		Queue q3 = new Queue(840);
		
		int box;
		int stepCounter=0;

		String user = "User1";
		
		while(!(stepCounter>21)) {
			if(user=="User1") {
				box=whichQueue();
				put(box,q1,q2,q3);
				Menu(user,q1,q2,q3);
				user= ("User2");
				stepCounter++;				
			}
			
			if(horizontalControl(q1) || horizontalControl(q2) || horizontalControl(q3) || verticalControl(q1,q2,q3)) {
				System.out.println("THE WINNER : "+ "User1");
				break;
			}
			
			else if(user=="User2") {
				box=whichQueue();
				put(box,q1,q2,q3);
				Menu(user,q1,q2,q3);
				user= ("User1");
				stepCounter++;
			}
			
			if(horizontalControl(q1) || horizontalControl(q2) || horizontalControl(q3) || verticalControl(q1,q2,q3)) {
				System.out.println("THE WINNER : "+ "User2");
				break;
			}
			
			if(stepCounter==22) {
				System.out.println("Tie");
			}
		}
				
		// System.out.println(stepCounter);		
	}

}
