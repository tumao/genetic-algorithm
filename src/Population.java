/**
 * 种群类，并且种群类中包含个体
 * @author changchun
 *
 */
public class Population
{
        private Individual [] individuals;                  // 一个种群中总的个体
//        private int individualSize = 60;

        /**
         * 构造函数
         * @param size  种群的大小
         * @param initalize     是否进行初始化
         */
        public Population (int size, boolean initialize)
        {
                individuals = new Individual [size];
                
                if (initialize == true)
                {
                        for (int i = 0; i < size; i++)
                        {
                                Individual newId = new Individual();
                                newId.generateIndividual();                                             // 为individual 生成一个基因序列
                                saveIndividual (newId, i);                                                   // 将实例化后等操作后的个体存储到种群中
                        }
                }
        }
        
        /**
         * 将一个个体的实例保存在数组中
         * @param id
         * @param index
         */
        public void saveIndividual (Individual id, int index)
        {
                individuals [index] = id;
        }
        
        /**
         * 获取种群的大小
         * @return
         */
        public int getSize ()
        {
                return individuals.length;
        }
        
        /**
         * 获取一个种群中的个体
         * @param index
         * @return
         */
        public Individual getIndividual (int index)
        {
                return individuals [index];
        }

      
        /**
         * 获取种群中最优的个体（适应度最高的个体）
         */
        public Individual getFittest ()
        {
                Individual fittest = individuals [0];
                
                for (int i = 1; i < individuals.length; i++ )
                {
                        if ( fittest.getFitness() <= individuals [i].getFitness())
                        {
                                fittest = individuals [i];
                        }
                }
                return fittest;
        }
        
        /**
         * 输出种群中最优秀的个体
         */
        public void printFittest()
        {
                Individual individual = getFittest();
                
                for (int i = 0; i < individual.getSize(); i++)
                {
                        System.out.print( individual.getGen (i));
                }
        }
        
        
}
