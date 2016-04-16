/**
 * 项目的入口文件
 * @author changchun
 *
 */
public class Index 
{

        public static void main(String[] args) 
        {
                Population pop = new Population (50, true);             // 初始化一个种群，并且位每个个体初始化
                Algorithm.setDestination("100001111010000111101000011110100001111010000111101000011110");     // 设置种群的进化的目标
                
                int i = 0; 
                while (pop.getFittest().getFitness() < Algorithm.getDest().length)
                {
                        pop = Algorithm.evolution  (pop);             // 进化
                        i++;
                        System.out.print ("这是第："+ i +"次进化");
                        System.out.println (",当前种群的适应度：" + pop.getFittest().getFitness());
                }
                
                System.out.println("经过" + i + "次的进化");
                System.out.print("当前种群中的个体进化到目标：");
                pop.printFittest();
                 
                 
                 
                
        }


}
