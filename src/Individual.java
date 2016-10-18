/**
 * 个体类，个体中包含若干个基因
 * @author changchun
 *
 */
public class Individual 
{
        private int genSize = 60;          // 每个个体包含基因的数量
        private byte [] gens = new byte [genSize];      // 存储基因序列
        
        /**
         * 生成一个带有基因序列的个体
         * @param size
         */
        public void generateIndividual ()
        {
                for (int i = 0; i < getSize(); i++)
                {
                        gens [i] = (byte) Math.round( Math.random());
                }
        }
        
        /**
         * 获取一组基因的长度
         * @return
         */
        public int getSize ()
        {
                return gens.length;
        }
        
        /**
         * 设置基因（例如：基因的某个位置突变，重新设置基因）
         * @param index
         * @param gen
         */
        public void setGens (int index, byte gen)
        {
                gens [index] = gen;
        }
        
        /**
         * 获取基因组中的基因
         * @param index
         * @return
         */
        public byte getGen (int index)
        {
                return gens [index];
        }
        
        /**
         * 获取当前individual的适应度
         * @return
         */
        public int getFitness()
        {
                byte [] dest = Algorithm.getDest();
                int fitCount = 0;
                
                for (int i = 0; i < dest.length; i++)
                {
                        if (this.gens [i] == dest [i])
                        {
                                fitCount = fitCount + 1;
                        }
                }
                return fitCount;
        }
        
        
}
