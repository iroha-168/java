class Practice2_02_1_janken{
	public static void main(String[] args){
		
		//------�V�i���I�@---------
		String player1_nm = args[0] ;
		String player2_nm = args[1] ;
		String judgement_nm = args[2] ;
		
		//------�V�i���I�A---------
		Practice2_02_1_player player1 = new Practice2_02_1_player( player1_nm );
		Practice2_02_1_player player2 = new Practice2_02_1_player( player2_nm );
		Practice2_02_1_referee referee = new Practice2_02_1_referee( judgement_nm );
		
		//------�V�i���I�B---------
		System.out.println( "�R��" + referee.getName() + ":�u�W�����P���c�|���I�I�I�I�I�v" ) ;
		player1.makeHandStatus();
		player2.makeHandStatus();
		referee.declareHandStatus( player1,player2 );
		
		//------�V�i���I�C---------
		System.out.println( "�R��" + referee.getName() + ":�u���ʂ́c�c�v" );
		referee.judgeGame( player1,player2 );
		
	}
}

		
		
		
		
		
		
		
		
		
		
		