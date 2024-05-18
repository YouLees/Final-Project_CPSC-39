//Using the Linkedlist java file from the linked list assignment

package finalProject;


//linkList2.java
//demonstrates linked list
//to run this program: C>java LinkList2App
////////////////////////////////////////////////////////////////
class Link  {
	//public int iData;              // data item (key)
	//public double dData;           // data item
	public Card cardObject;
	public Link next;              // next link in list
	//-------------------------------------------------------------
	//public Link(int id, double dd) // constructor
	public Link(Card newCard) {// constructor
		cardObject = newCard;
		next = null; //does automatically
	}
	//-------------------------------------------------------------
	public void displayLink()   {   // display ourself
		System.out.println(cardObject);
	}
	public Card getCardObject() {
		return cardObject;
	}

}  // end class Link
////////////////////////////////////////////////////////////////
class LinkList  {
	private Link first;            // ref to first link on list
	private static int size;

	//-------------------------------------------------------------
	public LinkList()    {          // constructor

		first = null;               // no links on list yet
		size = 0;
	}
	//-------------------------------------------------------------
	//public void insertFirst(int id, double dd)
	public void insertFirst(Card card)  {                           // make new link
		Link newLink = new Link(card);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
		size++;
	}
	//-------------------------------------------------------------
	//public void insertFirst(int id, double dd)
	//added this method for our project
	//gets the first card in the linkedList and returns it.
	//assumes cards in the list
	public Card getFirst()  {                       
		Link current = first;
		first = first.next;       // it points to old first link
		//first = newLink;            // now first points to this
		size--;
		return current.cardObject;
	}
	//-------------------------------------------------------------
	public Link find(Card cardToFind)      // find link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // start at 'first'
		//while(current.iData != key)        // while no match,
		while(!current.getCardObject().equals(cardToFind))
		{
			if(current.next == null)        // if end of list,
				return null;                 // didn't find it
			else                            // not end of list,
				current = current.next;      // go to next link
		}
		return current;                    // found it
	}
	//-------------------------------------------------------------
	//public Link delete(int key)    // delete link with given key
	public Link delete(Card cardToFind)    // delete link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // search for link
		Link previous = first;
		//while(current.iData != key)
		while(!current.getCardObject().equals(cardToFind))
		{
			if(current.next == null)
				return null;                 // didn't find it
			else
			{
				previous = current;          // go to next link
				current = current.next;
			}
		}                               // found it
		if(current == first)               // if first link,
			first = first.next;             //    change first
		else                               // otherwise,
			previous.next = current.next;   //    bypass it

		size--;

		return current;
	}
	//-------------------------------------------------------------
	public void displayList()      // display the list
	{
		System.out.print("List (first-->last): ");
		Link current = first;       // start at beginning of list
		while(current != null)      // until end of list,
		{
			current.displayLink();   // print data
			current = current.next;  // move to next link
		}
		System.out.println("");
	}

	public int getSize() {
		return size;
	}
	//-------------------------------------------------------------
}  // end class LinkList

////////////////////////////////////////////////////////////////