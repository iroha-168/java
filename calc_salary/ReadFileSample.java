import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/*
 *   WorkingResult.csv�i�ꂩ�����̋Ζ����уt�@�C���j��ǂݍ��݁A�e���̘J�����Ԃ��v�Z���ďo�͂��鏈���ł��B
 *   ���̃T���v���ł�WorkingResult.csv���uC:\WorkSpace�v�����ɔz�u���Ď��s����O��ɂȂ��Ă��܂��B
 *   �f�B���N�g���̖��O��z�u�ꏊ���Ⴄ�ꍇ�� WORKING_RESULT_FILE_PATH �̒l��K�؂Ȃ��̂ɕύX���Ă��������B
 */

public class ReadFileSample {
	public static void main(String[] args) {

		//  WorkingResult.csv�̃p�X ���uC:\WorkSpace�v�����ɔz�u���Ă��Ȃ��ꍇ�͓K�X�ύX���Ă��������B
		final String WORKING_RESULT_FILE_PATH = "C:\\WorkSpace\\Java.El\\Practice\\Test2\\WorkingResult.csv";
		// �R���}
		final String COMMA = ","; 

		// �v�Z�p�̐��l��萔�ŗp��
		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1���Ԃ̃~���b���Z
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1���̃~���b���Z
		final int  ONE_HOUR_BY_MIN       = 60;             // 1���Ԃ̕����Z


		List<String> workingResults = new ArrayList<String>(); //�t�@�C������ǂݍ��񂾃f�[�^���i�[���Ă���ArrayList

		//  WorkingResult.csv��ǂݍ���
		try {
			// WorkingResult.csv�̓ǂݍ��ݏ���
			File workingResultFile = new File(WORKING_RESULT_FILE_PATH);
			BufferedReader br = new BufferedReader(new FileReader(workingResultFile));

			// WorkingResult.csv��1�s���ǂݍ����ArrayList�Ɋi�[����
			String recode = br.readLine();
			while (recode != null) {
				workingResults.add(recode);
				recode = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		int sum_paycheck = 0; //for���̍Ō�Ɏg��sum_paycheck�̏�����
		// ArrayList����1�s�����o���ē��t/�o�Ύ���/�ދΎ��ԂɐU�蕪��
		for (int i = 0; i < workingResults.size() ; i++) {

			String workingRecode    = workingResults.get(i);      // 1�s������������o��
			String[] forSplitRecode = workingRecode.split(COMMA); // split���\�b�h��p���ăJ���}��؂�ŕ�����𕪉����z��ɂ��ꂼ��i�[

			Date workingDate = Date.valueOf(forSplitRecode[0]); // �o�Γ�
			Time startTime   = Time.valueOf(forSplitRecode[1]); // �o�Ύ���
			Time finishTime  = Time.valueOf(forSplitRecode[2]); // �ދΎ���

			// getTime���\�b�h���g���ĘJ�����Ԃ��~���b�i0.001�b�P�ʁj�Ŏ擾����
			long workingTime = finishTime.getTime() - startTime.getTime();
			
			int day_wtm = (int)(workingTime/ONE_MIN_BY_MILLI_SEC) ; //���������Ԃ𕪂݂̂ŕ\��
		
			// �~���b�Ŏ擾�����J�����Ԃ������ԁ����̌`���ɒ���
			int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // ���ԂɊ��Z
			int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN ); // ���Ɋ��Z
			
			int real_wtm = 0; //real_wtm�̏�����
			int paycheck = 0; //paycheck�̏�����
			int paycheckPerHour = 900 ;
			double paycheckPerMin = paycheckPerHour/60 ;
			
			if((6<=workingHour) && (workingHour<8)){		
				real_wtm = day_wtm - 45 ;
				paycheck = (int)Math.floor(real_wtm * paycheckPerMin) ;
				
			}else if( 8<=workingHour ){
				real_wtm = day_wtm - 60 ;
				
				if( real_wtm>8*60 ){
					int zngy_min = real_wtm - 8*60 ;
					paycheck = (int)Math.floor( 8*60*paycheckPerMin ) + (int)Math.floor( zngy_min*paycheckPerMin*1.25 ) ;
					
				}else{
					paycheck = (int)Math.floor( real_wtm*paycheckPerMin ) ;
				}
				
			}else{
				real_wtm = day_wtm ;
				paycheck = (int)Math.floor(real_wtm * paycheckPerMin) ;
			}
			
			sum_paycheck = sum_paycheck + paycheck ;
			
		}
		
		System.out.println("�����̂�������" + sum_paycheck + "�~�ł��B");
		System.out.println( "�����������l�ł����B");
	}
}

