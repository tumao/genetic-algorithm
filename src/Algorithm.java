/**
 * 基因的一些操作
 * @author changchun
 *
 */
public class Algorithm 
{
        private static byte [] destination = new byte [60];    // 该种群最终要达到的目的
        
        private static double pc = 0.5;        // 染色体的交叉概率
        
        private static double pm = 0.02;        // 染色体的变异的概率
        
        private static int tournamentSize = 5;             // 淘汰数组的大小
        
        /**
         * 为种群设置一个最终目标,并且将一个字符串转化为二进制数组
         * @param str
         */
        public static void setDestination (String str)
        {
                destination = new byte [str.length()];
                String singleChar;
                
                for (int i = 0; i < str.length(); i++)
                {
                        singleChar = str.substring(i, i+1);
                        if (singleChar.contains ("1") || singleChar.contains ("0"))
                        {
                                destination [i] = Byte.parseByte( singleChar);
                        }
                        else                                                                                            // 如果字符串中的字符，不是由0、1组成，那么非0、1的都转为0
                        {
                                destination [i] = 0;
                        }
                }
        }
        
        /**
         * 两个个体交叉
         * @param indiv1
         * @param indiv2
         * @return
         */
        public static Individual cross (Individual indiv1, Individual indiv2)
        {
                Individual newIndividual = new Individual ();
                
                for (int i = 0; i < newIndividual.getSize(); i++)
                {
                        if ( Math.random() < pc)
                        {
                                byte gen = indiv1.getGen (i);
                                newIndividual.setGens (i, gen);
                        }
                        else
                        {
                                byte gen = indiv2.getGen (i);
                                newIndividual.setGens (i, gen);
                        }
                }
                
                return newIndividual;
        }
        
        /**
         * 个体的变异
         * @param indiviudla
         * @return
         */
        public static void mutation (Individual individual)
        {
                for (int i = 0; i < individual.getSize(); i++)
                {
                        if ( Math.random() < pm)        // 变异是随机的，如果当前情况小于变异的概率则变异
                        {
                                byte gen = (byte) Math.round (Math.random ());
                                individual.setGens(i, gen);
                        }
                }
        }

        /**
         * 种群的进化
         * @param pop
         */
        public static Population evolution (Population pop)
        {
                Population newPop = new Population (pop.getSize(), false);      // 新建一个种群，和原始种群大小相同，用来存储进化后的种群
                
                for (int i = 0; i < pop.getSize(); i++ )
                {
                        Individual indiv1 = select (pop);
                        Individual indiv2 = select (pop);
                        Individual newIndividual = cross (indiv1, indiv2);      // 交配产生新的个体
                        newPop.saveIndividual(newIndividual, i);                // 将交叉后的新的个体存入种群
                }
                
                for (int j = 0; j < newPop.getSize(); j++)                              // 突变
                {
                        mutation (newPop.getIndividual (j));
                }
                return newPop;
        }
        
        /**
         * 获取种群进化的目标
         */
        public static byte [] getDest ()
        {
                return destination;
        }
        
        /**
         * 在群组中找出一个相对优秀的个体
         * @param pop
         * @return
         */
        public static Individual select (Population pop)
        {
                Population tournament = new Population (tournamentSize, false);  // 淘汰群组

                for (int i = 0; i < tournamentSize; i++)
                {
                       int randId = (int) (Math.random() * pop.getSize());      // 随机生成一个id
                       tournament.saveIndividual (pop.getIndividual (randId), i);       // 把随机的一个individual 存储到淘汰群组中
                }
                Individual newIndividual = tournament.getFittest();     // 保留淘汰数组中适应度最高的个体
                return newIndividual;
        }
        
        
        
}
