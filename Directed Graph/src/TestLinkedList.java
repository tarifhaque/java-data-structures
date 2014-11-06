class TestLinkedList {
	public static void main(String args[]) {
		LinkedList<String> strings = new LinkedList<>();
		strings.add("Hello " );
		strings.add("My ");
		strings.add("Name ");
		strings.insert(0, "Waddup ");
		strings.insert(4, "is ");
		strings.remove(strings.get(0));
		System.out.println(strings.indexOf(strings.get(4)));
		
		for (int i = 0; i < strings.size(); i++) {
			String x = strings.get(i);
			System.out.print(x);
		}
		
		System.out.println(strings.size());
	}
}