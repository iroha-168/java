class Practice2_02_1_referee{
	
	//------�t�B�[���h-------
	private String name ;
	
	//------�R���X�g���N�^------
	Practice2_02_1_referee( String nm ){
		this.name = nm ;
	}
	
	//------���\�b�h-------
	
	//declareHandStatus���\�b�h
	public void declareHandStatus( Practice2_02_1_player player1,Practice2_02_1_player player2 ){
		System.out.println( "�R��" + this.name + ":�u" + player1.getName() + "����̎��" + player1.getHandStatus() + "�ł���!!�v" );
		System.out.println( "�R��" + this.name + ":�u" + player2.getName() + "����̎��" + player2.getHandStatus() + "�ł���!!�v" );
	}
	
	//judgeGame���\�b�h
	public void judgeGame( Practice2_02_1_player player1,Practice2_02_1_player player2 ){
		
		if(player1.getHandStatus().equals(player2.getHandStatus())){
			
			System.out.println( "�R��" + this.name + ":�u�������I���������I�I�I�v" ) ;
			
		}else if(((player1.getHandStatus().equals("�O�["))&&(player2.getHandStatus().equals("�`���L")))||((player1.getHandStatus().equals("�p�["))&&(player2.getHandStatus().equals("�O�[")))||((player1.getHandStatus().equals("�`���L"))&&(player2.getHandStatus().equals("�p�[")))){		
			
			System.out.println( "�R��" + this.name + ":�u" + player1.getName() + "����̏����v" ) ;
			
		}else if(((player2.getHandStatus().equals("�O�["))&&(player1.getHandStatus().equals("�`���L")))||((player2.getHandStatus().equals("�p�["))&&(player1.getHandStatus().equals("�O�[")))||((player2.getHandStatus().equals("�`���L"))&&(player1.getHandStatus().equals("�p�[")))){
			
			System.out.println( "�R��" + this.name + ":�u" + player2.getName() + "����̏����v" ) ;
			
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





