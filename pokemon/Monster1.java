import java.math.BigDecimal;

class Monster1{
	//-------�t�B�[���h-----------
	String character = "(unknown)";    //�푰
	String trainer = "(wild)";         //�g���[�i�[
	String name = "(noname)";          //�Ȃ܂�
	int lv = 1;                        //���x��
	int hp = 30;                       //HP
	int atk = 15;                      //��������
	int def = 10;                      //�ڂ�����
	int spd = 10;                      //���΂₳
	int hp_max = 30;                   //HP�����l
	String waza_nm = "����������";     //�킴�i�Ȃ܂��j
	String waza_dmg_rate = "1.0";      //�킴�i�_���[�W�{���j
	
	//--------���\�b�h---------
	//toString���\�b�h
	public String toString(){
		return "character:" + character + "/" + "trainer:" + trainer + "/" + "name:" + name + "/" + "lv:" + lv + "/" + "hp:" + lv + "/" + "atk:" + atk + "/" + "def:" + def + "/" + "spd:" + spd + "/" + "hp_max:" + hp_max + "/" + "waza_nm:" + waza_nm + "/" + "waza_dmg_rate:" + waza_dmg_rate ;
	}
	
	//levelUp���\�b�h
	public void levelUp( int lv_up ){
		if( lv_up == 0){
			//�����Ȃ�
		}else if( lv_up > 0 ){
			lv = lv + lv_up * 1;
			hp_max = hp_max + lv_up * 15;
			atk = atk + lv_up * 5;
			def = def + lv_up * 5;
			spd = spd + lv_up * 5;
			hp = hp_max;
		}
	}
	
	//setWaza���\�b�h
	public void setWaza( String wz_nm, String wz_dg_rt ){
		String str = wz_dg_rt ;
		
		if( str.matches("^[0-9]+\.[0-9]$")){
			waza_nm = wz_nm;
			waza_dmg_rate = wz_dg_rt;
		}else{
			System.out.println("[ERROR]�킴�̐ݒ�Ɏ��s���܂���");
		}
	}
	
	//getStatus���\�b�h
	public String getStatus(){
		String resultMessage = "[" + name + "lv" + lv + "HP" + hp + "/" + hp_max + "]" ;
		return resultMessage ;
	}
	
	//useWaza���\�b�h
	public int useWaza(){
		BigDecimal a = BigDecimal.valueOf(atk);
		BigDecimal w = new BigDecimal(waza_dmg_rate);
		BigDecimal give_dmg = (a.multiply(w)).setScale(0,BigDecimal.ROUND_DOWN);
		
		int result_give_dmg = give_dmg.intValue();
		
		return result_give_dmg;
	}
	
	//damaged���\�b�h
	public int damaged(int gv_dmg){
		//�_���[�W���Z�������߂�
		BigDecimal one = new BigDecimal("1");
		BigDecimal hun_twny = new BigDecimal("120");
		BigDecimal df = BigDecimal.valueOf(def);
		BigDecimal denom = one.add(df.divide(hun_twny));
		BigDecimal given_dmg_rate = one.divide(denom,2,BigDecimal.ROUND_UP);
		
		//���ۂɎ󂯂�_���[�W�����߂�
		BigDecimal gd = BigDecimal.valueOf(gv_dmg);
		BigDecimal given_dmg = gd.multiply(given_dmg_rate);
		int result_given_dmg = given_dmg.intValue();
		
		//HP�̕ω�
		if( hp > result_given_dmg ){
			hp = hp - result_given_dmg;
		}else{
			hp = 0;
		}
		return result_given_dmg;
	}
}

