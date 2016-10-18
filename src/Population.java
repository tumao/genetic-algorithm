/**
 * ��Ⱥ�࣬������Ⱥ���а�������
 * @author changchun
 *
 */
public class Population
{
        private Individual [] individuals;                  // һ����Ⱥ���ܵĸ���
//        private int individualSize = 60;

        /**
         * ���캯��
         * @param size  ��Ⱥ�Ĵ�С
         * @param initalize     �Ƿ���г�ʼ��
         */
        public Population (int size, boolean initialize)
        {
                individuals = new Individual [size];
                
                if (initialize == true)
                {
                        for (int i = 0; i < size; i++)
                        {
                                Individual newId = new Individual();
                                newId.generateIndividual();                                             // Ϊindividual ����һ����������
                                saveIndividual (newId, i);                                                   // ��ʵ������Ȳ�����ĸ���洢����Ⱥ��
                        }
                }
        }
        
        /**
         * ��һ�������ʵ��������������
         * @param id
         * @param index
         */
        public void saveIndividual (Individual id, int index)
        {
                individuals [index] = id;
        }
        
        /**
         * ��ȡ��Ⱥ�Ĵ�С
         * @return
         */
        public int getSize ()
        {
                return individuals.length;
        }
        
        /**
         * ��ȡһ����Ⱥ�еĸ���
         * @param index
         * @return
         */
        public Individual getIndividual (int index)
        {
                return individuals [index];
        }

      
        /**
         * ��ȡ��Ⱥ�����ŵĸ��壨��Ӧ����ߵĸ��壩
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
         * �����Ⱥ��������ĸ���
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
