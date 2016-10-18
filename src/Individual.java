/**
 * �����࣬�����а������ɸ�����
 * @author changchun
 *
 */
public class Individual 
{
        private int genSize = 60;          // ÿ������������������
        private byte [] gens = new byte [genSize];      // �洢��������
        
        /**
         * ����һ�����л������еĸ���
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
         * ��ȡһ�����ĳ���
         * @return
         */
        public int getSize ()
        {
                return gens.length;
        }
        
        /**
         * ���û������磺�����ĳ��λ��ͻ�䣬�������û���
         * @param index
         * @param gen
         */
        public void setGens (int index, byte gen)
        {
                gens [index] = gen;
        }
        
        /**
         * ��ȡ�������еĻ���
         * @param index
         * @return
         */
        public byte getGen (int index)
        {
                return gens [index];
        }
        
        /**
         * ��ȡ��ǰindividual����Ӧ��
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
