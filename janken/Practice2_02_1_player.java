import java.util.Random;

class Practice2_02_1_player{
	
	//-------�t�B�[���h------
	private String name ;
	private String handStatus ;
	
	//-------�R���X�g���N�^--------
	Practice2_02_1_player( String nm ){
		this.name = nm ;
	}
	
	//-------���\�b�h---------
	public void makeHandStatus(){
		String[] makeHands = { "�O�[","�`���L","�p�[" };
		
		Random rnd = new Random();
		this.handStatus = makeHands[rnd.nextInt(3)] ;
	}
	
	//-------getter/setter--------
	
	public String getName(){
		return this.name ;
	}
	public void setName(){
		this.name = name ;
	}
	
	public String getHandStatus(){
		return this.handStatus ;
	}
	public void setHandStatus(){
		this.handStatus = handStatus ;
	}
	
}

