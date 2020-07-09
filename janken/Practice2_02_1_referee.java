class Practice2_02_1_referee{
	
	//------フィールド-------
	private String name ;
	
	//------コンストラクタ------
	Practice2_02_1_referee( String nm ){
		this.name = nm ;
	}
	
	//------メソッド-------
	
	//declareHandStatusメソッド
	public void declareHandStatus( Practice2_02_1_player player1,Practice2_02_1_player player2 ){
		System.out.println( "審判" + this.name + ":「" + player1.getName() + "さんの手は" + player1.getHandStatus() + "でした!!」" );
		System.out.println( "審判" + this.name + ":「" + player2.getName() + "さんの手は" + player2.getHandStatus() + "でした!!」" );
	}
	
	//judgeGameメソッド
	public void judgeGame( Practice2_02_1_player player1,Practice2_02_1_player player2 ){
		
		if(player1.getHandStatus().equals(player2.getHandStatus())){
			
			System.out.println( "審判" + this.name + ":「あいこ！勝負つかず！！！」" ) ;
			
		}else if(((player1.getHandStatus().equals("グー"))&&(player2.getHandStatus().equals("チョキ")))||((player1.getHandStatus().equals("パー"))&&(player2.getHandStatus().equals("グー")))||((player1.getHandStatus().equals("チョキ"))&&(player2.getHandStatus().equals("パー")))){		
			
			System.out.println( "審判" + this.name + ":「" + player1.getName() + "さんの勝ち」" ) ;
			
		}else if(((player2.getHandStatus().equals("グー"))&&(player1.getHandStatus().equals("チョキ")))||((player2.getHandStatus().equals("パー"))&&(player1.getHandStatus().equals("グー")))||((player2.getHandStatus().equals("チョキ"))&&(player1.getHandStatus().equals("パー")))){
			
			System.out.println( "審判" + this.name + ":「" + player2.getName() + "さんの勝ち」" ) ;
			
		}
	}
	
	//-----getter/setter-------
	public String getName(){
		return this.name;
	}
	public void setName(){
		this.name = name ;
	}
	
}





