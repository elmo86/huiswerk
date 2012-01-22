public class app
{
	public static void main(String[] arg)
	{
		sortedlist st = new sortedlist();
		for (int i = 0; i < 20; i++)
		{
			// Data
			int leeftijd = 18 + (i / 2);
			String geslacht = ((i % 4) == 0) ? "f" : "m";
			String naam = "student " + i;
			int student = leeftijd * i;

			student s = new student(student, naam, geslacht, leeftijd);

			System.out.println("Adding " + student);

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

		System.out.println("===============================================Push back");
		st.push(last);
		System.out.println("===============================================");
		st.printStack();

		System.out.println("===============================================TAIL");

		last = st.tail();
		last.printStudent();

		System.out.println("===============================================");
		st.printStack();

		System.out.println("===============================================Push back");
		st.push(last);
		System.out.println("===============================================");
		st.printStack();	

		System.out.println("===============================================delete(5)");
		last = st.delete(5);
		last.printStudent();

		System.out.println("===============================================");
		st.printStack();	

		System.out.println("===============================================Push back");
		st.push(last);
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
	}
}
