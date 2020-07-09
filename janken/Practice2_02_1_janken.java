class Practice2_02_1_janken{
	public static void main(String[] args){
		
		//------シナリオ①---------
		String player1_nm = args[0] ;
		String player2_nm = args[1] ;
		String judgement_nm = args[2] ;
		
		//------シナリオ②---------
		Practice2_02_1_player player1 = new Practice2_02_1_player( player1_nm );
		Practice2_02_1_player player2 = new Practice2_02_1_player( player2_nm );
		Practice2_02_1_referee referee = new Practice2_02_1_referee( judgement_nm );
		
		//------シナリオ③---------
		System.out.println( "審判" + referee.getName() + ":「ジャンケン…ポン！！！！！」" ) ;
		player1.makeHandStatus();
		player2.makeHandStatus();
		referee.declareHandStatus( player1,player2 );
		
		//------シナリオ④---------
		System.out.println( "審判" + referee.getName() + ":「結果は……」" );
		referee.judgeGame( player1,player2 );
		
	}
}

		
		
		
		
		
		
		
		
		
		
		