public class app
{
	public static void main(String[] arg)
	{
	list st = new list();
	for (int i = 0; i < 20; i++)
	{
		// Data
		int leeftijd = 18 + (i / 2);
		String geslacht = ((i % 4) == 0) ? "f" : "m";
		String naam = "student " + i;
		int student = leeftijd * i;

		student s = new student(student, naam, geslacht, leeftijd);

		if (!st.peek(s))
			st.push(s);
		else
			System.out.println("Error?");
	}

	System.out.println("===============================================");
	st.printStack();
	System.out.println("===============================================M==");
	st.printmen();
	System.out.println("===============================================F==");
	st.printwomen();
	System.out.println("===============================================HEAD");

	student last = st.head();

	last.printStudent();

	System.out.println("===============================================");
	st.printStack();
	System.out.println("===============================================TAIL");

	last = st.tail();
	last.printStudent();

	System.out.println("===============================================");
	st.printStack();

	System.out.println("===============================================Push(index 3)");
	st.push(last, 3);

	System.out.println("===============================================");
	st.printStack();

	System.out.println("===============================================Check last exists");
	if(st.peek(last))
	{
		System.out.println("Yes");
	}
	else
	{
		System.out.println("No");
	}
	System.out.println("===============================================delete(index 3) (And compare)");
	student lst = st.delete(3);

	lst.printStudent();

	if (lst.getStudent() == last.getStudent())
	{
		System.out.println("OK");
	}
	else
	{
		System.out.println("FAULT!");
	}

	System.out.println("===============================================");
	st.printStack();

	System.out.println("===============================================push with high index");	
	st.push(lst, st.getSize() + 100);

	System.out.println("===============================================");
	st.printStack();	
	}
}
