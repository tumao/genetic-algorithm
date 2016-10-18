/**
 * �����һЩ����
 * @author changchun
 *
 */
public class Algorithm 
{
        private static byte [] destination = new byte [60];    // ����Ⱥ����Ҫ�ﵽ��Ŀ��
        
        private static double pc = 0.5;        // Ⱦɫ��Ľ������
        
        private static double pm = 0.02;        // Ⱦɫ��ı���ĸ���
        
        private static int tournamentSize = 5;             // ��̭����Ĵ�С
        
        /**
         * Ϊ��Ⱥ����һ������Ŀ��,���ҽ�һ���ַ���ת��Ϊ����������
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
                        else                                                                                            // ����ַ����е��ַ���������0��1��ɣ���ô��0��1�Ķ�תΪ0
                        {
                                destination [i] = 0;
                        }
                }
        }
        
        /**
         * �������彻��
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
         * ����ı���
         * @param indiviudla
         * @return
         */
        public static void mutation (Individual individual)
        {
                for (int i = 0; i < individual.getSize(); i++)
                {
                        if ( Math.random() < pm)        // ����������ģ������ǰ���С�ڱ���ĸ��������
                        {
                                byte gen = (byte) Math.round (Math.random ());
                                individual.setGens(i, gen);
                        }
                }
        }

        /**
         * ��Ⱥ�Ľ���
         * @param pop
         */
        public static Population evolution (Population pop)
        {
                Population newPop = new Population (pop.getSize(), false);      // �½�һ����Ⱥ����ԭʼ��Ⱥ��С��ͬ�������洢���������Ⱥ
                
                for (int i = 0; i < pop.getSize(); i++ )
                {
                        Individual indiv1 = select (pop);
                        Individual indiv2 = select (pop);
                        Individual newIndividual = cross (indiv1, indiv2);      // ��������µĸ���
                        newPop.saveIndividual(newIndividual, i);                // ���������µĸ��������Ⱥ
                }
                
                for (int j = 0; j < newPop.getSize(); j++)                              // ͻ��
                {
                        mutation (newPop.getIndividual (j));
                }
                return newPop;
        }
        
        /**
         * ��ȡ��Ⱥ������Ŀ��
         */
        public static byte [] getDest ()
        {
                return destination;
        }
        
        /**
         * ��Ⱥ�����ҳ�һ���������ĸ���
         * @param pop
         * @return
         */
        public static Individual select (Population pop)
        {
                Population tournament = new Population (tournamentSize, false);  // ��̭Ⱥ��

                for (int i = 0; i < tournamentSize; i++)
                {
                       int randId = (int) (Math.random() * pop.getSize());      // �������һ��id
                       tournament.saveIndividual (pop.getIndividual (randId), i);       // �������һ��individual �洢����̭Ⱥ����
                }
                Individual newIndividual = tournament.getFittest();     // ������̭��������Ӧ����ߵĸ���
                return newIndividual;
        }
        
        
        
}
