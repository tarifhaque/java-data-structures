class Main {
	public static void main (String args[ ]) {
		int j, k, m=0;
		Tree T = new Tree( );
		for (j=1; j<=3; j++) {
			T.addLeftmostChild (++m);
			T.gotoLeftmostChild( );
			for (k=1; k<=3; k++)
				T.addRightmostChild (++m);
			T.gotoParent( );
		}
		T.levelOrder( );
		System.out.println (T.size( ));
		while (!T.isLeaf( ))
			T.gotoRightmostChild( );
		System.out.println (T.label( ));
		T.replaceLabel (++m);
		while (!T.isRoot( ))
			T.gotoParent( );
		while (!T.isLeaf( ))
			T.gotoLeftmostChild( );
		System.out.println (T.label( ));
		T.replaceLabel (++m);
		T.gotoRoot( );
		T.gotoRightmostChild( );
		for (j=1; j<=3; j++) {
			T.replaceLabel (++m);
			T.gotoLeftSibling( );
		}
		T.preOrder( );
		for (k=1; k<=3; k++) {
			T.replaceLabel (++m);
			T.gotoRightSibling( );
		}
		T.postOrder( );
	}
}