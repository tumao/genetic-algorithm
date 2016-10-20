import java.util.Arrays;

/**
 * �Ŵ��㷨����ʲ��������
 * @author �γ���
 *
 */
public class NashEq
{
	
	public static void main(String[] args)
	{
		NashEq ns = new NashEq();
		ns.init(2, 3);		// ����3������Ϊ2���������
	}
	
	/**
	 * ��������û�ָ����С�Ļ�ϲ�������
	 * 
	 * @param length ����ĳ���
	 * @param number ����ĸ���
	 */
	public double[][] init(int length, int number)
	{
		double[][] profile = new double[length][number];		// ����
		double[] profileCell; // һ����������
		
		for(int i = 0; i < number; i++)
		{
			profileCell = randProfile(length);		// �������һ��ָ�����ȵ�����
			
			for(int j = 0; j < length; j++)
			{
				profile[j][i] = profileCell[j];
			}
		}
		
		return profile;
	}
	
	/**
	 * �������һ������
	 * 
	 * @param length ����ĳ���
	 */
	private double[] randProfile(int length)
	{
		double sum = 0;
		double[] profile = new double[length];
		
		for(int i = 0; i < length; i++)	// �������һ��ָ����������
		{
			profile[i] =  (double)(Math.round(Math.random() * 100))/100.0;
			sum = sum + profile[i];
		}
		
		for(int i = 0; i < length; i++)		// ��������й�һ������
		{
			profile[i] = (double)(Math.round(profile[i]/sum * 100))/100.0;
		}
		return profile;
	}
	
	/**
	 * ����ƫ���
	 * 
	 * @return
	 */
//	public double sReg()
//	{
//		return 0;
//	}
	
	public 
}
