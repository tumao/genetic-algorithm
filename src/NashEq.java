import java.util.Arrays;

/**
 * 遗传算法求纳什均衡剖面
 * @author 任长春
 *
 */
public class NashEq
{
	
	public static void main(String[] args)
	{
		NashEq ns = new NashEq();
		ns.init(2, 3);		// 生成3个长度为2的随机剖面
	}
	
	/**
	 * 随机生成用户指定大小的混合策略剖面
	 * 
	 * @param length 剖面的长度
	 * @param number 剖面的个数
	 */
	public double[][] init(int length, int number)
	{
		double[][] profile = new double[length][number];		// 剖面
		double[] profileCell; // 一个策略剖面
		
		for(int i = 0; i < number; i++)
		{
			profileCell = randProfile(length);		// 随机生成一个指定长度的剖面
			
			for(int j = 0; j < length; j++)
			{
				profile[j][i] = profileCell[j];
			}
		}
		
		return profile;
	}
	
	/**
	 * 随机生成一个剖面
	 * 
	 * @param length 剖面的长度
	 */
	private double[] randProfile(int length)
	{
		double sum = 0;
		double[] profile = new double[length];
		
		for(int i = 0; i < length; i++)	// 随机生成一个指定长度剖面
		{
			profile[i] =  (double)(Math.round(Math.random() * 100))/100.0;
			sum = sum + profile[i];
		}
		
		for(int i = 0; i < length; i++)		// 对剖面进行归一化处理
		{
			profile[i] = (double)(Math.round(profile[i]/sum * 100))/100.0;
		}
		return profile;
	}
	
	/**
	 * 计算偏离度
	 * 
	 * @return
	 */
//	public double sReg()
//	{
//		return 0;
//	}
	
	public 
}
