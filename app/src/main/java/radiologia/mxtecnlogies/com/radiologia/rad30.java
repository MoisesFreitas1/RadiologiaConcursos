package radiologia.mxtecnlogies.com.radiologia;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Moisés on 05/02/2016.
 */
public class rad30 extends Fragment {
    private TextView questaoTextView;
    private TextView textView;
    private RadioButton a;
    private RadioButton b;
    private RadioButton c;
    private RadioButton d;
    private RadioButton e;
    private RadioGroup rg;
    private int opcao;
    private int tentativas;
    private int alternativa;
    int[] nquestion;
    int nquestions;
    int m;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.content_radiologia,container,false);
        nquestions = 334;
        m=0;
        tentativas=0;
        textView = (TextView) view.findViewById(R.id.textView);
        questaoTextView = (TextView) view.findViewById(R.id.questaoTextView);
        rg = (RadioGroup)view.findViewById(R.id.rgopcoes);
        a = (RadioButton)view.findViewById(R.id.a);
        b = (RadioButton)view.findViewById(R.id.b);
        c = (RadioButton)view.findViewById(R.id.c);
        d = (RadioButton)view.findViewById(R.id.d);
        e = (RadioButton)view.findViewById(R.id.e);
        nquestion = new int[30];
        int tquestions [];
        int aux;
        Random random  = new Random();
        tquestions = new int[nquestions];
        for(int b=0;b<nquestions;b++){
            tquestions[b]=b+1;
        }
        for (int n=0;n<30;n++){
            do{
                aux=random.nextInt(nquestions);
                nquestion[n]=tquestions[aux];
            }while(tquestions[aux]==0);
            tquestions[aux]=0;
        }

        alternativa=update(nquestion[m]);
        textView.setText((m + 1) + " de "+nquestion.length);

        Button button1 = (Button)view.findViewById(R.id.button1);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        opcao = rg.getCheckedRadioButtonId();
                        alternativa = update(nquestion[m]);
                        textView.setText((m + 1) + " de "+nquestion.length);
                        if (opcao != alternativa) {
                            tentativas = tentativas + 1;
                            AlertDialog.Builder mensagem = new AlertDialog.Builder(getActivity());
                            mensagem.setTitle("Atenção!");
                            mensagem.setMessage("Alternativa incorreta");
                            mensagem.setNeutralButton("OK", null);
                            mensagem.show();
                        }

                        if (opcao == alternativa) {
                            if (m == (nquestion.length-1)) {
                                tentativas = tentativas + 1;
                                AlertDialog.Builder mensagem1 = new AlertDialog.Builder(getActivity());
                                mensagem1.setTitle("   ESTATÍSTICAS");
                                mensagem1.setMessage(tentativas + " tentativas para responder " + nquestion.length + " questões");
                                mensagem1.setNeutralButton("Finalizar", null);
                                mensagem1.show();
                            }

                            if (m < (nquestion.length-1)) {
                                tentativas = tentativas + 1;
                                AlertDialog.Builder mensagem = new AlertDialog.Builder(getActivity());
                                mensagem.setTitle("Parabéns!");
                                mensagem.setMessage("Alternativa correta");
                                mensagem.setNeutralButton("OK", null);
                                mensagem.show();
                                m = m + 1;
                                alternativa = update(nquestion[m]);
                                textView.setText((m + 1) + " de " + nquestion.length);
                            }
                        }
                    }
                });
        Button button2 = (Button)view.findViewById(R.id.button2);
        button2.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        if(m>0) {
                            m = m - 1;
                            alternativa = update(nquestion[m]);
                            textView.setText((m + 1) + " de "+nquestion.length);
                        }else{
                            Toast.makeText(getActivity(), "Início do Teste", Toast.LENGTH_SHORT).show();

                        }
                    }

                });


        return view;
    }

    private int update(int question) {
        int alt = -1;
        if (question == 0) {
            questaoTextView.setText("Fratura da metade proximal da ulna, seguida de deslocamento da cabeça do rádio. Esta é a definição da fratura de: ");
            a.setText("Colles");
            b.setText("Smith");
            c.setText("Monteggia");
            d.setText("Bennet");
            e.setText("Baleazzi");
            alt = R.id.b;
        }
        if (question == 1) {
            questaoTextView.setText("O hormônio Cortisol é produzido no(a): ");
            a.setText("pâncreas");
            b.setText("hipófise");
            c.setText("paratireóide");
            d.setText("supra renal");
            e.setText("adeno hipófise");
            alt = R.id.d;
        }
        if (question == 2) {
            questaoTextView.setText("O fator secundário da densidade é o(a): ");
            a.setText("tempo");
            b.setText("miliamperagem");
            c.setText("distorção");
            d.setText("absorção");
            e.setText("kilovoltagem");
            alt = R.id.b;
        }
        if (question == 3) {
            questaoTextView.setText("Atualmente, a qualidade de imagem é considerada fator primordial na aquisição e melhoramento radiográfico.  Considerando os fatores de controle e correção deste padrão, como se deve corrigir uma radiografia subexposta de mão, realizada com fator técnico de 30 kvp, duplicando-se a densidade?  ");
            a.setText("25,5 kVp");
            b.setText("60 kVp");
            c.setText("34,5 kVp");
            d.setText("30 kVp");
            e.setText("15 kVp");
            alt = R.id.a;
        }
        if (question == 4) {
            questaoTextView.setText("A estrutura anatômica ‘’junção ureterovesical’’ está localizada no(a):  ");
            a.setText("rim");
            b.setText("uretra");
            c.setText("bexiga");
            d.setText("vesícula biliar");
            e.setText("ureter");
            alt = R.id.d;
        }
        if (question == 5) {
            questaoTextView.setText("Segundo a portaria 453/1998, qual o valor mínimo da camada semi-redutora, quando a tensão máxima de um tubo de operação é de 120 kvp, com rendimento de um gerador trifásico? ");
            a.setText("2,5");
            b.setText("3,0");
            c.setText("3,2");
            d.setText("3,5");
            e.setText("3,9");
            alt = R.id.e;
        }
        if (question == 6) {
            questaoTextView.setText("Em relação aos meios de contrastes iônicos, quais são consideradas reações moderadas?");
            a.setText("Tosse, tremores, hipotensão e edema de glote");
            b.setText("Rubor, sudorese, hipotensão e arritmias");
            c.setText("Hipotensão, hipertensão, edema facial e cefaléia intensa");
            d.setText("Urticária intensa, edema de glote, dor torácica e tremores");
            e.setText("Laringo espasmo, tosse, colapso vascular severo e edema agudo de pulmão");
            alt = R.id.d;
        }
        if (question == 7) {
            questaoTextView.setText("Em tomografia computadorizada, de acordo com a escala de Hounsfield, um tecido do tipo ósseo poroso equivale a:  ");
            a.setText("-900 a -450H");
            b.setText("70 a 80H");
            c.setText("100 a 200H");
            d.setText("600 a 700H");
            e.setText("acima de 1.000H");
            alt = R.id.a;
        }
        if (question == 8) {
            questaoTextView.setText("Secção tomográfica axial, adquirida ao nível do teto acetabular, demonstra: ");
            a.setText("glúteo médio, asa ilíaca e vértebra L-5");
            b.setText("glúteo maior, corpo do ilíaco e bexiga");
            c.setText("glúteo menor, cólon ascendente e reto");
            d.setText("glúteo maior, asa ilíaca e bexiga");
            e.setText("glúteo médio, corpo do ilíaco e vértebra  L-5");
            alt = R.id.b;
        }
        if (question == 9) {
            questaoTextView.setText("É considerada contra-indicação absoluta para a realização de angiografia digital periférica: ");
            a.setText("doença aterosclerótica");
            b.setText("oclusão ou estreitamento de vaso");
            c.setText("traumatismo");
            d.setText("aneurisma cerebral");
            e.setText("embolia ou trombose");
            alt = R.id.d;
        }
        if (question == 10) {
            questaoTextView.setText("Em um determinado exame de raios X, o técnico ajustou os fatores técnicos com 420 mA e tempo de exposição de 1/60 segundo.  Nesse contexto, é correto afirmar que ele utilizou um fator de exposição de: ");
            a.setText("0,7 mAs");
            b.setText("7 mAs");
            c.setText("70 mAs");
            d.setText("0,07 mAs");
            e.setText("700 mAs");
            alt = R.id.b;
        }
        if (question == 11) {
            questaoTextView.setText("Qual o método frequentemente utilizado para cateterismo e subsequente realização de angiografia? ");
            a.setText("Técnica de Lewis");
            b.setText("Técnica de Roberts");
            c.setText("Técnica de Seldinger");
            d.setText("Técnica de Clark");
            e.setText("Técnica de Moret");
            alt = R.id.d;
        }
        if (question == 12) {
            questaoTextView.setText("O fêmur é uma estrutura densa e os raios X, para cruzarem esta estrutura, necessitam de uma onda altamente penetrante. Diante disso, é necessária uma ampola de ânodo giratório. Assinale corretamente a alternativa que contém os respectivos componentes que formam a ampola e os constituintes da camada que revestem o fêmur, interna e externamente. ");
            a.setText("Ferro, ar, chumbo, vidro e óleo; endósteo e pericôndrio");
            b.setText("Ferro, chumbo, vácuo, vidro e óleo; epimisio e periósteo");
            c.setText("Ferro, vácuo, óleo, vidro e tungstênio; endósteo e periósteo");
            d.setText("Ferro, chumbo, vidro, vácuo e tungstênio; periósteo e endósteo");
            e.setText("Ferro, chumbo, óleo, vidro e vácuo; endósteo e periósteo");
            alt = R.id.e;
        }
        if (question == 13) {
            questaoTextView.setText("Na Doença de Scheuermann, qual segmento da coluna vertebral é largamente afetado? ");
            a.setText("Sacro");
            b.setText("Cervical");
            c.setText("Cóccix");
            d.setText("Torácica e Lombar");
            e.setText("Disco vertebral");
            alt = R.id.b;
        }
        if (question == 14) {
            questaoTextView.setText("A Fratura de Pott está diretamente ligada a que tipo de estrutura óssea? ");
            a.setText("1/3 distal do rádio");
            b.setText("1/3 médio do fêmur");
            c.setText("1/3 distal da fíbula");
            d.setText("1/3 proximal do antebraço");
            e.setText("1/3 distal do úmero");
            alt = R.id.c;
        }
        if (question == 15) {
            questaoTextView.setText("O estresse em eversão do tornozelo também pode ser classificado como: ");
            a.setText("dorsiflexão");
            b.setText("rotação");
            c.setText("valgo");
            d.setText("abdução");
            e.setText("circundação");
            alt = R.id.a;
        }
        if (question == 16) {
            questaoTextView.setText("A única sindesmose verdadeira do corpo humano está localizada na: ");
            a.setText("articulação temporo-mandibular");
            b.setText("sutura craniana");
            c.setText("articulação esterno-clavicular");
            d.setText("articulação atlanto-axial");
            e.setText("articulação tibiofibular distal");
            alt = R.id.e;
        }
        if (question == 17) {
            questaoTextView.setText("Existem vários planos e linhas imaginários que podem ser traçados nas cavidades abdominal e pélvica com o objetivo de facilitar a localização de estruturas anatômicas, no estudo radiológico convencional do abdome. O plano transumbilical é um plano transversal que passa através da cicatriz umbilical e de qual espaço intervertebral?");
            a.setText("L1-L2");
            b.setText("L2-L3");
            c.setText("L3-L4");
            d.setText("L4-L5");
            e.setText("L5-S1");
            alt = R.id.c;
        }
        if (question == 18) {
            questaoTextView.setText("Na rotina do estudo radiográfico convencional da sela turca, a incidência localizada semiaxial anteroposterior, também denominada Reverchon, é utilizada para:");
            a.setText("avaliação da estrutura óssea do dorso da sela");
            b.setText("visualização do processo clinoide anterior");
            c.setText("mensuração do quiasma óptico");
            d.setText("confirmação de lesões da haste hipofisária");
            e.setText("delineação da linha de Chamberlain");
            alt = R.id.a;
        }
        if (question == 19) {
            questaoTextView.setText("Quais são as incidências utilizadas na rotina radiográfica básica para avaliação da articulação talocrural?");
            a.setText("Anteroposterior e tangencial");
            b.setText("Oblíquas externa e interna");
            c.setText("Tangencial e perfil interno");
            d.setText("Perfil externo e oblíqua interna");
            e.setText("Anteroposterior e perfil externo");
            alt = R.id.e;
        }
        if (question == 20) {
            questaoTextView.setText("No estudo radiográfico do cotovelo, existem pontos anatômicos de referência superficial que são úteis para facilitar a realização do exame. Dentre eles, o olécrano, que é palpável em que região do cotovelo?");
            a.setText("Medial");
            b.setText("Lateral");
            c.setText("Posterior");
            d.setText("Anterior");
            e.setText("Radial");
            alt = R.id.c;
        }
        if (question == 21) {
            questaoTextView.setText("O exame contrastado que tem como objetivo a opacificação das vias urinárias superiores através de uma punção direta do rim, no qual normalmente são realizadas incidências panorâmicas do abdome em decúbito ventral em posteroanterior, é denominado de:");
            a.setText("urografia excretora");
            b.setText("uretrocistografia");
            c.setText("pielografia retrógrada");
            d.setText("pielografia anterógrada");
            e.setText("sialografia");
            alt = R.id.d;
        }
        if (question == 22) {
            questaoTextView.setText("Como é denominado o equipamento radiológico móvel, simples, usado para a realização de exames radiográficos no leito, inclusive em Unidades de Terapia Intensiva e Coronárias?");
            a.setText("Fixo");
            b.setText("Transportável");
            c.setText("Arco cirúrgico");
            d.setText("Radioscopia");
            e.setText("Telecomandado");
            alt = R.id.b;
        }
        if (question == 23) {
            questaoTextView.setText("Como é denominada a incidência complementar no estudo radiográfico da articulação do quadril, na qual o paciente deve estar deitado em decúbito dorsal na mesa, com os membros inferiores estendidos e posicionados com a região posterior apoiada na mesa, devendo-se rodar o paciente para o lado oposto a ser examinado, de maneira que a região dorsal forme um ângulo de aproximadamente 45º com a superfície da mesa e o lado a ser examinado fique mais afastado da superfície da mesa, ficando o membro inferior do lado a ser examinado estendido, e o contralateral, flexionado?");
            a.setText("Farril");
            b.setText("Fergunson");
            c.setText("Obturatriz");
            d.setText("Chaussé");
            e.setText("Nahum");
            alt = R.id.c;
        }
        if (question == 24) {
            questaoTextView.setText("Os seios da face são cavidades aeríficas localizadas em alguns ossos da cabeça. Qual deles está presente antes do nascimento, atingindo o tamanho total na adolescência, possuindo paredes finas, sendo o teto formado pelo assoalho das órbitas?");
            a.setText("Frontais");
            b.setText("Maxilares");
            c.setText("Etmoidais");
            d.setText("Esfenoidais");
            e.setText("Zigomáticos");
            alt = R.id.e;
        }
        if (question == 25) {
            questaoTextView.setText("No estudo radiográfico da coluna cervical, a incidência complementar que demonstra com razoável definição as vértebras cervicais inferiores e as torácicas superiores é:");
            a.setText("anteroposterior");
            b.setText("oblíqua anteroposterior");
            c.setText("perfil esquerdo dinâmico");
            d.setText("perfil com o braço levantado");
            e.setText("oblíqua em transoral");
            alt = R.id.d;
        }
        if (question == 26) {
            questaoTextView.setText("Em relação aos equipamentos de proteção individual, as vestimentas plumbíferas  não devem ser dobradas e quando não estiverem em uso, devem ser mantidas de forma a preservar sua integridade. Como isto é conseguido?");
            a.setText("Mantendo-a sem local seco e livre de umidade");
            b.setText("Colocando-as sobre superfície horizontal ou em suporte apropriado");
            c.setText("Fazendo irradiação com baixa dosagem de Raios-X pelo menos uma vez ao mês");
            d.setText("Descartando-as após um ano de uso");
            e.setText("Enviando-as para esterilização periodicamente");
            alt = R.id.b;
        }
        if (question == 27) {
            questaoTextView.setText("Qual dos princípios básicos de proteção radiológica estabelece que as instalações e as práticas devem ser planejadas, implantadas e executadas de modo que a magnitude das doses individuais, o número de pessoas expostas e a probabilidade de exposições acidentais sejam tão baixos quanto razoavelmente exequíveis?");
            a.setText("Justificação");
            b.setText("Limitação");
            c.setText("Prevenção");
            d.setText("Otimização");
            e.setText("Responsabilização");
            alt = R.id.d;
        }
        if (question == 28) {
            questaoTextView.setText("O osso cuboide, que pode ser visualizado nas incidências em oblíquas e anteroposterior, está localizado em qual região anatômica?");
            a.setText("Mão");
            b.setText("Punho");
            c.setText("Pé");
            d.setText("Quadril");
            e.setText("Cotovelo");
            alt = R.id.c;
        }
        if (question == 29) {
            questaoTextView.setText("Qual é a incidência complementar em mamografia, na qual a paciente deve estar preferencialmente em posição ortostática, com a cabeça virada para o lado que está em estudo, o membro superior contralateral deve estar estendido e com a paciente de frente para o aparelho, o operador deve girar o conjunto tubo de Raios-X/chassi em cerca de 45º e colocar a região da axila e a parte superior do braço sobre o bucky?");
            a.setText("Craniocaudal");
            b.setText("Mediolateral oblíqua");
            c.setText("Perfil lateromedial");
            d.setText("Axilar");
            e.setText("Craniocaudal exagerada");
            alt = R.id.d;
        }
        if (question == 30) {
            questaoTextView.setText("As incidências oblíquas posteriores internas semiaxiais correspondem a uma série de quatro incidências que variam em função do ângulo de entrada do raio central. Utilizadas como complementares no estudo radiográfico do tornozelo, são também denominadas de incidência de:");
            a.setText("Broden");
            b.setText("Cleavage");
            c.setText("Stenvers");
            d.setText("Judet");
            e.setText("Fergunson");
            alt = R.id.a;
        }
        if (question == 31) {
            questaoTextView.setText("Como é denominada a incidência complementar no estudo radiográfico do ápice pulmonar, do lobo médio e dos segmentos lingulares, na qual o paciente deve estar em ortostática, com a região posterior do tórax próxima à superfície do bucky vertical, sendo que as clavículas aparecem projetadas fora dos campos pulmonares?");
            a.setText("Anteroposterior exagerada");
            b.setText("Oblíqua anterior esquerda");
            c.setText("Oblíqua posteroanterior direita");
            d.setText("Decúbito lateral (Hjelm-Laurell)");
            e.setText("Apicolordótica em anteroposterior");
            alt = R.id.e;
        }
        if (question == 32) {
            questaoTextView.setText("O esqueleto humano adulto é formado por 206 ossos distintos que compõem a estrutura de todo o organismo. É dividido em esqueleto axial e apendicular. Quais dos ossos apresentados a seguir fazem parte do esqueleto apendicular? ");
            a.setText("Clavículas, Cervical e Úmero");
            b.setText("Escápulas, Ulna e Rádio");
            c.setText("Fêmur, Fíbula e Costelas");
            d.setText("Esterno, Tíbia e Fêmur");
            e.setText("Rádio, Falanges e Ossos da Face");
            alt = R.id.b;
        }
        if (question == 33) {
            questaoTextView.setText("A construção da câmara escura deve obedecer aos requisitos especificados na Portaria 453 de 1 de junho de 1998. Dentre esses requisitos está a distância da iluminação de segurança. De acordo com a portaria, a distância da lâmpada em relação ao local de manipulação dos filmes não deve ser inferior a");
            a.setText("1,5 metros");
            b.setText("2,5 metros");
            c.setText("1,2 metros");
            d.setText("5 metros");
            e.setText("1,3 metros");
            alt = R.id.c;
        }
        if (question == 34) {
            questaoTextView.setText("As imagens radiográficas realizadas em filmes são avaliadas com base em quatro fatores de qualidade. Quais são esses?");
            a.setText("Densidade, contraste, resolução e distorção");
            b.setText("Detalhe, contraste, ruído e nitidez");
            c.setText("Brilho, distorção, densidade e nitidez");
            d.setText("Distorção, índice de exposição, contraste e densidade");
            e.setText("Ruído, brilho, detalhe e contraste");
            alt = R.id.a;
        }
        if (question == 35) {
            questaoTextView.setText("As imagens radiográficas digitais são visualizadas em um monitor de computador. Cada imagem digital é formada por uma matriz de quadros de elementos chamada de ");
            a.setText("Voxel");
            b.setText("Bit");
            c.setText("Pitch");
            d.setText("Pixel");
            e.setText("Fov");
            alt = R.id.d;
        }
        if (question == 36) {
            questaoTextView.setText("Uma das vantagens da radiografia digital é a transferência rápida das imagens por meio eletrônico dentro de um hospital, centro cirúrgico ou consultório. É possível também enviar as imagens para outros hospitais ou centros especializados para consultas por especialistas ou para laudo. A transmissão eletrônica de imagens de uma localidade para outra, com o propósito de interpretação ou consulta, é conhecida como ");
            a.setText("PACS");
            b.setText("Telerradiologia");
            c.setText("DICOM");
            d.setText("Imaginologia");
            e.setText("Transferência");
            alt = R.id.b;
        }
        if (question == 37) {
            questaoTextView.setText("Os fatores utilizados para avaliar a qualidade de uma imagem digital são seis. A definição “Distúrbio aleatório que obscurece ou reduz a nitidez. Em uma imagem radiográfica, isso se traduz em aparência granulada ou pontilhada da imagem” refere-se ao fator ");
            a.setText("ruído");
            b.setText("contraste");
            c.setText("resolução");
            d.setText("distorção");
            e.setText("brilho");
            alt = R.id.a;
        }
        if (question == 38) {
            questaoTextView.setText("Na Radiologia digital, o chassi com filme foi substituído por cassete digital ou RD (Radiografia Digital Direta). O tamanho do chassi é determinado em centímetros. No cassete digital, o tamanho é determinado em polegadas. Um cassete digital de tamanho 10X12 polegadas equivale em tamanho a um chassi de ");
            a.setText("18x24 cm");
            b.setText("24x24 cm");
            c.setText("24x30 cm");
            d.setText("35X35 cm");
            e.setText("35x43 cm");
            alt = R.id.c;
        }
        if (question == 38) {
            questaoTextView.setText("O princípio de proteção denominado ALARA é muito eficiente na proteção de pacientes e principalmente do técnico. Esse é um princípio de segurança com o objetivo de minimizar as doses de radiação em pacientes e trabalhadores. O que está de acordo com o princípio ALARA?");
            a.setText("Não usar dispositivo de restrição e sempre segurar o paciente quando necessário na hora do exame");
            b.setText("Realizar o exame com o colimador totalmente aberto");
            c.setText("Segurar o paciente sem o uso de avental plumbífero ou protetor de tireoide");
            d.setText("Possibilitar que acompanhantes permaneçam sem necessidade na sala na hora do exame");
            e.setText("Sempre usar um dosímetro de monitoramento pessoal");
            alt = R.id.e;
        }
        if (question == 39) {
            questaoTextView.setText("“São efeitos em que a probabilidade de ocorrência é proporcional à dose de radiação recebida, sem a existência de limiar. Isso significa que doses pequenas, abaixo dos limites estabelecidos por normas e recomendações de radioproteção, podem induzir a tais efeitos”. A descrição citada refere-se a qual efeito biológico da radiação? ");
            a.setText("Efeitos estocásticos");
            b.setText("Efeitos determinísticos");
            c.setText("Efeitos somáticos");
            d.setText("Efeitos genéticos ou hereditários");
            e.setText("Efeitos imediatos e tardios");
            alt = R.id.a;
        }
        if (question == 40) {
            questaoTextView.setText("De acordo com as diretrizes de proteção radiológica, a idade mínima exigida para que uma pessoa possa atuar como profissional de radiologia é de ");
            a.setText("17 anos");
            b.setText("20 anos");
            c.setText("25 anos");
            d.setText("18 anos");
            e.setText("22 anos");
            alt = R.id.d;
        }
        if (question == 41) {
            questaoTextView.setText("Exames de Tomografia Computadorizada e Ressonância Magnética utilizam planos imaginários (cortes) que passam através do corpo em posição anatômica. Os quatros planos comuns utilizados nesse tipo de exame são: ");
            a.setText("sagital, coronal, horizontal (axial) e posterior");
            b.setText("horizontal, coronal, posterior e transverso");
            c.setText("sagital, coronal, horizontal (axial) e oblíquo");
            d.setText("sagital, oblíquo, longitudinal e lateral");
            e.setText("coronal, transverso, horizontal (axial) e sagital");
            alt = R.id.c;
        }
        if (question == 42) {
            questaoTextView.setText("A radiação secundária são raios aleatórios que atingem o filme no momento da realização do exame. O dispositivo utilizado para absorver a maior parte dessa radiação secundária chama-se");
            a.setText("colimador");
            b.setText("cilindro");
            c.setText("cone");
            d.setText("Buck");
            e.setText("grade antidifusora");
            alt = R.id.e;
        }
        if (question == 43) {
            questaoTextView.setText("Vários exames de raios-x exigem angulações do raio central. O instrumento utilizado para medir essas angulações corretamente é ");
            a.setText("o goniômetro");
            b.setText("o espessômetro");
            c.setText("a régua");
            d.setText("o densitômetro");
            e.setText("o micrómetro");
            alt = R.id.a;
        }
        if (question == 44) {
            questaoTextView.setText("Em um exame de Tomografia Computadorizada (TC), a relação entre a velocidade da mesa e a espessura do corte é denominada ");
            a.setText("Voxel");
            b.setText("Pitch");
            c.setText("Pixel");
            d.setText("Matriz");
            e.setText("Imagem");
            alt = R.id.b;
        }
        if (question == 45) {
            questaoTextView.setText("Nos exames de Tomografia Computadorizada (TC), os parâmetros para aquisição de imagens variam para cada estrutura a ser analisada, levando em conta fatores como pitch, campo de visão, espessura do corte. Esse conjunto de fatores pré-estabelecidos na TC é chamado de");
            a.setText("Scout");
            b.setText("Reconstrução");
            c.setText("Escanograma");
            d.setText("Matriz ");
            e.setText("Protocolo");
            alt = R.id.e;
        }
        if (question == 46) {
            questaoTextView.setText("Os exames de Medicina Nuclear são realizados utilizando radiofármacos que são uma combinação de um material radioativo com uma droga farmacêutica. O radiofármaco mais utilizado nesses exames é o tecnécio-99m, pois possui uma meia vida bastante curta. A meia vida do tecnécio-99m é de");
            a.setText("2 horas");
            b.setText("6 horas");
            c.setText("15 horas");
            d.setText("20 horas");
            e.setText("25 horas");
            alt = R.id.b;
        }
        if (question == 47) {
            questaoTextView.setText("A diferença da intensidade de radiação emitida entre as extremidades do tubo de raios-x, conhecida como efeito anódico, pode ser utilizada no exame de");
            a.setText("tórax");
            b.setText("mão");
            c.setText("pé");
            d.setText("fêmur");
            e.setText("joelho");
            alt = R.id.d;
        }
        if (question == 48) {
            questaoTextView.setText("Em um paciente realiza-se um exame de tórax com espessura de 22 cm e a constante (K) do aparelho é igual a 30. Quantos KV deverão ser utilizados nesse exame? ");
            a.setText("52");
            b.setText("65");
            c.setText("74");
            d.setText("78");
            e.setText("80");
            alt = R.id.c;
        }
        if (question == 49) {
            questaoTextView.setText("A fórmula matemática utilizada para achar o KV correto para cada exposição radiográfica é ");
            a.setText("KV=(K+E)x2");
            b.setText("KV=(2xK)+E");
            c.setText("KV=K+(Ex3)");
            d.setText("KV=2xE");
            e.setText("KV=(Ex2)+K");
            alt = R.id.e;
        }
        if (question == 50) {
            questaoTextView.setText("Alguns pacientes apresentam contraindicação para realização de um exame de Ressonância Magnética. Entre os pacientes citados a seguir, qual apresenta contraindicação para esse exame? ");
            a.setText("Paciente alérgico");
            b.setText("Paciente portador de grampo de aneurisma");
            c.setText("Paciente com labirintite");
            d.setText("Paciente com câncer");
            e.setText("Paciente com prótese dentária");
            alt = R.id.b;
        }
        if (question == 51) {
            questaoTextView.setText("A qualidade das imagens é essencial para um bom diagnóstico. As imagens podem ser afetadas pela presença de artefatos. Ruído eletrônico, dobra da imagem, desvio químico e mapeamento incorreto são artefatos gerados nas imagens de");
            a.setText("ressonância magnética");
            b.setText("tomografia computadorizada");
            c.setText("raios-x");
            d.setText("ultrassom");
            e.setText("densitometria óssea");
            alt = R.id.a;
        }
        if (question == 52) {
            questaoTextView.setText("O Gadolínio é um elemento da família dos metais nobres e é o meio de contraste mais utilizado em exames de ");
            a.setText("ultrassom");
            b.setText("tomografia computadorizada");
            c.setText("ressonância magnética");
            d.setText("cintilografia");
            e.setText("raios-x");
            alt = R.id.c;
        }
        if (question == 53) {
            questaoTextView.setText("Em relação aos equipamentos de Teleterapia utilizados em Radioterapia, assinale a alternativa correta. ");
            a.setText("Os equipamentos de raios X superficial ou de ortovoltagem são empregados nos tratamentos de vários tipos de lesões independente da profundidade de infiltração delas. ");
            b.setText("Nos equipamentos de Cobalto-60, a emissão de fótons gama é contínua e independe de o equipamento estar desligado. ");
            c.setText("Os aceleradores lineares não podem gerar fótons de energia maior do que os fótons gerados pelo equipamento de Cobalto-60. ");
            d.setText("Nos aceleradores lineares, nêutrons são acelerados a grandes velocidades em um tubo com vácuo para a obtenção de fótons de raios X. ");
            e.setText("No tratamento com acelerador linear, fótons de alta energia depositam maior dose de radiação na pele e nos tecidos sadios do paciente. ");
            alt = R.id.b;
        }

        if (question == 54) {
            questaoTextView.setText("De acordo com a técnica de tratamento de Braquiterapia, é correto afirmar que ");
            a.setText("a dose de radiação recebida pelo tecido aumenta com o aumento da distância entre o tecido e a fonte de braquiterapia. ");
            b.setText("na braquiterapia o tumor recebe altas doses de radiação, assim como os tecidos sadios vizinhos. ");
            c.setText("as fontes de braquiterapia normalmente permanecem no paciente entre 24 horas e 72 horas. ");
            d.setText("a braquiterapia constitui uma forma de tratamento na qual a fonte de radiação encontra-se a uma determinada distância da área a ser tratada. ");
            e.setText("nos casos de tratamento em que são utilizadas sementes de ouro-198, as fontes não podem permanecer no paciente por mais tempo, devido ao rápido decaimento dessas fontes. ");
            alt = R.id.c;
        }
        if (question == 55) {
            questaoTextView.setText("Sobre o posicionamento dos pacientes nos tratamentos de radioterapia, assinale a alternativa correta. ");
            a.setText("A precisão na reprodutibilidade do posicionamento do paciente não interfere no sucesso do tratamento radioterápico. ");
            b.setText("A imobilização e o posicionamento do paciente nunca interferem na localização de campos de irradiação. ");
            c.setText("O paciente deve ser posicionado de forma a estar confortável e relaxado durante o tratamento. ");
            d.setText("Os dispositivos utilizados para a imobilização do paciente sempre interferem no plano de tratamento por atenuar o feixe de radiação. ");
            e.setText("Dispositivos de imobilização do paciente nunca são confeccionados dentro do próprio serviço de radioterapia. ");
            alt = R.id.c;
        }
        if (question == 56) {
            questaoTextView.setText("Em relação à cavidade abdominal e aos órgãos abdominais, é INCORRETO afirmar que ");
            a.setText("topograficamente o abdome pode ser dividido em seis regiões anatômicas. ");
            b.setText("o peritônio apresenta duas lâminas contínuas: peritônio parietal e visceral. ");
            c.setText("o fígado, o baço e o estômago são exemplos de órgãos intraperitoneais. ");
            d.setText("o baço está localizado no quadrante superior esquerdo do abdome. ");
            e.setText("estruturas anatômicas como rins e ureteres são órgãos retroperitoneais. ");
            alt = R.id.a;
        }
        if (question == 57) {
            questaoTextView.setText("De acordo com a anatomia radiográfica do tórax, assinale a alternativa INCORRETA. ");
            a.setText("A anatomia radiográfica do tórax pode ser dividia em três partes: caixa torácica, sistema respiratório e mediastino. ");
            b.setText("A proeminência vertebral da sétima vértebra cervical e a fúrcula esternal são estruturas de referência topográfica para o posicionamento do paciente. ");
            c.setText("O termo víscera torácica é utilizado para descrever as estruturas dos pulmões e órgãos torácicos alojados no mediastino. ");
            d.setText("O pulmão direito apresenta três lobos e o pulmão esquerdo apenas dois. ");
            e.setText("As glândulas tireoide e paratireoides são estruturas mediastinais. ");
            alt = R.id.e;
        }
        if (question == 58) {
            questaoTextView.setText("Sobre a Tomografia Computadorizada com simulador (CT-Simulador), é correto afirmar que ");
            a.setText("a delimitação do campo de tratamento nunca é feita pelo estudo da região anatômica através do método de tomografia computadorizada. ");
            b.setText("o tomógrafo simulador apresenta um conjunto de lasers independentes e móveis nos eixos X e Z. ");
            c.setText("mediante o uso somente do CT-simulador, a localização do isocentro não é realizada no próprio tomógrafo. ");
            d.setText("as imagens obtidas no CT-Simulador são enviadas para o sistema de planejamento em plataforma JPEG. ");
            e.setText("o CT-Simulador corresponde a um equipamento de tomografia computadorizada que não é adaptado ao planejamento radioterápico. ");
            alt = R.id.b;
        }
        if (question == 59) {
            questaoTextView.setText("Assinale a alternativa INCORRETA sobre os acessórios de imobilização utilizados em radioterapia. ");
            a.setText("As máscaras de acrílico utilizadas para a imobilização da região da cabeça podem afetar a distribuição da dose na região, podendo provocar reações na pele maiores do que as previstas. ");
            b.setText("Imobilizadores pélvicos são muito úteis nos casos da radioterapia conformacional. ");
            c.setText("Os imobilizadores a vácuo não podem ser moldados de acordo com a região anatômica a ser tratada. ");
            d.setText("Pacientes que irradiam a região de cabeça e pescoço devem utilizar o extensor de ombros como acessório, a fim de retirar os ombros da região de incidência do feixe de radiação. ");
            e.setText("O suporte denominado de base em T é utilizado no tratamento de irradiação dos pulmões quando a entrada do feixe de radiação requer campos oblíquos. ");
            alt = R.id.c;
        }
        if (question == 60) {
            questaoTextView.setText("Sobre a anatomia radiográfica do crânio, é correto afirmar que ");
            a.setText("a calota craniana é formada pelos ossos frontal, parietal direito e esquerdo, occiptal e esfenoide. ");
            b.setText("o osso esfenoide apresenta uma depressão central em sua estrutura denominada forame oval. ");
            c.setText("a sutura lambdoide separa o osso frontal dos ossos parietais direito e esquerdo. ");
            d.setText("a base do crânio é formada apenas pelos ossos occiptal, esfenoide e etmoide. ");
            e.setText("os órgãos da audição estão localizados na porção petrosa do osso temporal. ");
            alt = R.id.e;
        }
        if (question == 61) {
            questaoTextView.setText("De acordo com a Radioatividade, assinale a alternativa correta. ");
            a.setText("A emissão não espontânea de partículas ou energia do interior de um núcleo atômico é denominada desintegração nuclear. ");
            b.setText("Os termos desintegração nuclear e decaimento radioativo não são sinônimos. ");
            c.setText("O número de decaimentos por unidade de tempo de uma amostra radioativa é denominado concentração. ");
            d.setText("No decaimento gama, é emitido um fóton de raio gama de energia correspondente à diferença entre dois níveis de energia nuclear. ");
            e.setText("No decaimento alfa, a perda de energia pelo núcleo radioativo ocorre através da emissão de um nêutron. ");
            alt = R.id.d;
        }
        if (question == 62) {
            questaoTextView.setText("Em relação aos raios X, é correto afirmar que ");
            a.setText("os raios X são ondas eletromagnéticas que não são desviadas por campos elétricos e magnéticos. ");
            b.setText("o cátodo é o eletrodo positivo do tubo de raios X. ");
            c.setText("a área do ânodo na qual ocorrem as interações dos elétrons não é denominada alvo. ");
            d.setText("os elétrons são acelerados dentro do tubo de raios X por meio da aplicação de um campo magnético entre os eletrodos presentes no tubo. ");
            e.setText("o material que compõem o cátodo deve apresentar baixo ponto de fusão e alto número atômico. ");
            alt = R.id.a;
        }
        if (question == 63) {
            questaoTextView.setText("De acordo com as técnicas radiológicas da coluna vertebral, é correto afirmar que ");
            a.setText("a incidência radiográfica transoral em anteroposterior é realizada para o estudo do processo odontoide. ");
            b.setText("nos posicionamentos oblíquos anteriores e posteriores da coluna cervical não é possível a visibilização dos forames intervertebrais. ");
            c.setText("a radiografia lateral com o paciente em ortostase não corresponde a uma incidência básica para a rotina de estudo de escoliose. ");
            d.setText("na incidência anteroposterior axial do cóccix o raio central deve incidir angulado 45° no sentido caudal, aproximadamente, cinco centímetros acima da sínfise púbica. ");
            e.setText("as incidências oblíquas anterior e posterior da coluna torácica são consideradas incidências básicas de rotina. ");
            alt = R.id.a;
        }
        if (question == 64) {
            questaoTextView.setText("Sobre as técnicas radiológicas empregadas no estudo do tórax, assinale a alternativa INCORRETA. ");
            a.setText("Na incidência posteroanterior do tórax, o raio central deve ser centralizado no plano mediossagital ao nível da sétima vértebra torácica. ");
            b.setText("Nas radiografias de tórax, é desejável a obtenção de uma longa escala de contraste para que as estruturas vasculares no interior dos pulmões possam ser observadas. ");
            c.setText("A região de hilo pulmonar pode ser observada nas radiografias em perfil do tórax. ");
            d.setText("Nas radiografias de tórax posteroanterior e perfil, deve ser solicitado ao paciente que permaneça em expiração total. ");
            e.setText("No posicionamento do perfil de tórax, o lado esquerdo do paciente deve ficar em contato com o receptor de imagem. ");
            alt = R.id.d;
        }
        if (question == 65) {
            questaoTextView.setText("De acordo com a aplicação da Radioproteção em Braquiterapia, assinale a alternativa correta. ");
            a.setText("A técnica de pós-carregamento remoto aumenta a dose recebida pelos profissionais. ");
            b.setText("Os profissionais podem olhar diretamente para as fontes radioativas sem a implicação de maiores problemas. ");
            c.setText("As fontes utilizadas na Braquiterapia devem ser sempre manuseadas pelos profissionais atrás de blindagens. ");
            d.setText("Não há restrições quanto ao tempo em que visitantes podem ficar perto do paciente submetido a tratamento de Braquiterapia.");
            e.setText("O quarto de tratamento do paciente não necessita ser blindado. ");
            alt = R.id.c;
        }
        if (question == 66) {
            questaoTextView.setText("Assinale a alternativa correta sobre os Acelerados Lineares utilizados em Radioterapia. ");
            a.setText("No canhão de elétrons do equipamento, ocorre a geração dos nêutrons que serão acelerados. ");
            b.setText("Os colimadores não são responsáveis pela definição do campo a ser tratado. ");
            c.setText("A refrigeração do equipamento é feita por meio da circulação de gás carbônico. ");
            d.setText("O Acelerador Linear pode ser utilizado para a produção de raios X de alta energia, assim como para a produção de elétrons. ");
            e.setText("O Acelerador Linear é um exemplo de equipamento empregado na modalidade de tratamento de Braquiterapia. ");
            alt = R.id.d;
        }
        if (question == 67) {
            questaoTextView.setText("Em relação à Radioterapia de Intensidade Modulada (MTR), é INCORRETO afirmar que ");
            a.setText("a técnica de MTR representa uma avançada modalidade de tratamento que possibilita um maior controle de irradiação de tecidos tumorais e uma minimização da dose nos tecidos sadios vizinhos. ");
            b.setText("a complexidade do equipamento de MTR utilizado na administração da dose de radiação destaca-se como uma dificuldade encontrada para a implantação de tal tecnologia na rotina clínica de um Serviço de Radioterapia. ");
            c.setText("a técnica de MTR, apesar de limitar a irradiação de estruturas anatômicas vizinhas ao tumor, não possibilita uma maior homogeneidade de deposição da dose de radiação no interior do volume alvo. ");
            d.setText("um Programa de Controle de Qualidade é necessário para garantir o correto funcionamento do equipamento e, consequentemente, a aplicação de doses adequadas nos pacientes. ");
            e.setText("modalidades de imagem como a Tomografia Computadorizada, Ressonância Magnética e Tomografia por Emissão de Pósitrons podem auxiliar no planejamento 3D do tratamento radioterápico. ");
            alt = R.id.c;
        }
        if (question == 68) {
            questaoTextView.setText("De acordo com o planejamento tridimensional ou conformacional utilizado nos Tratamentos Radioterápicos, assinale a alternativa correta. ");
            a.setText("A radioterapia tridimensional inviabiliza o aumento da dose no volume alvo. ");
            b.setText("Para um planejamento 3D, são requeridas as etapas de pré-simulação, realização do exame, delineamento, determinação do isocentro e planejamento. ");
            c.setText("Na simulação do planeamento tridimensional, não é necessário o uso de imobilizadores que serão utilizados durante o tratamento do paciente. ");
            d.setText("O planejamento tridimensional deve ser realizado somente em um CT-simulador. ");
            e.setText("O planejamento 3D permite a obtenção de arranjo de campos mais complexos, mas não aumenta a precisão do planejamento em relação ao planejamento radioterápico realizado por meio de radiografias ortogonais. ");
            alt = R.id.b;
        }
        if (question == 69) {
            questaoTextView.setText("Assinale a alternativa correta com relação à etapa de Delineamento das estruturas, que é realizada no planejamento tridimensional do Tratamento Radioterápico. ");
            a.setText("Para o delineamento do volume alvo são necessárias somente duas definições: GTV (Volume Tumoral Visível ou Palpável) e CTV (Volume Alvo). ");
            b.setText("O GTV (Volume Tumoral Visível ou Palpável) corresponde a parte do tumor em que há uma maior concentração de células malignas. ");
            c.setText("O desenho do CTV (Volume Alvo) baseia-se em considerações topográficas e anatômicas do paciente considerando o movimento do paciente e dos órgãos. ");
            d.setText("Nos casos de remoção cirúrgica do tumor, o GTV (Volume Tumoral Visível ou Palpável) ainda pode ser definido. ");
            e.setText("O PTV (Volume de Planejamento) não faz parte do delineamento do volume alvo. ");
            alt = R.id.b;
        }
        if (question == 70) {
            questaoTextView.setText("Sobre a anatomia do Sistema Gastrointestinal, é INCORRETO afirmar que ");
            a.setText("as glândulas salivares, o pâncreas, o fígado e a vesícula biliar são órgãos acessórios do Sistema Gastrointestinal. ");
            b.setText("a faringe é dividida em nasofaringe, orofaringe e laringofaringe. ");
            c.setText("o esôfago encontra-se localizado posteriormente à traqueia. ");
            d.setText("a glândula parótida localiza-se abaixo da mandíbula. ");
            e.setText("a junção esofagogástrica também é denominada orifício cardíaco. ");
            alt = R.id.d;
        }
        if (question == 71) {
            questaoTextView.setText("Com relação aos órgãos pélvicos e as estruturas pertencentes ao Sistema Urinário, é correto afirmar que ");
            a.setText("a bexiga urinária, a uretra e os órgãos reprodutores masculinos são órgãos retroperitoniais. ");
            b.setText("os ureteres situam-se na superfície posterior do músculo psoas maior. ");
            c.setText("o plexo venoso vesical circunda as extremidades superiores dos ureteres. ");
            d.setText("a estrutura do reto constitui a porção abdominal do tubo digestório. ");
            e.setText("pelve renal é a nomenclatura associada à expansão afunilada e achatada da extremidade superior do ureter. ");
            alt = R.id.e;
        }
        if (question == 72) {
            questaoTextView.setText("De acordo com os equipamentos de raios X utilizados em Radioterapia, é correto afirmar que ");
            a.setText("independente do caso clínico a ser tratado, são utilizados feixes de raios X de mesma energia. ");
            b.setText("na Terapia Superficial a distância foco-filme e/ou foco/ pele é menor ou igual a dois centímetros. ");
            c.setText("a Terapia de Contato também é denominada ortovoltagem. ");
            d.setText("na Terapia Profunda a distância foco-superfície de tratamento varia de um a dez centímetros. ");
            e.setText("a Terapia Profunda é empregada no tratamento de tumores de pele e na prevenção de queloides. ");
            alt = R.id.e;
        }
        if (question == 73) {
            questaoTextView.setText("Assinale a alternativa INCORRETA em relação aos suportes de posicionamento empregados em Radioterapia. ");
            a.setText("Travesseiros e colchões de espuma são utilizados para auxiliar no conforto de pacientes que apresentam dor e metástases ósseas. ");
            b.setText("Na base em T, utilizada para irradiação da região pulmonar, os braços do paciente devem ser posicionados para cima. ");
            c.setText("O triângulo de apoio pode ser posicionado sob os joelhos do paciente, quando este estiver na posição de decúbito ventral. ");
            d.setText("A rampa de mama é um acessório que permite que o braço do paciente fique em uma abertura perpendicular ao campo de tratamento. ");
            e.setText("O extensor de ombros é utilizado para auxiliar no posicionamento de pacientes que irradiam as regiões de cabeça e pescoço. ");
            alt = R.id.c;
        }
        if (question == 74) {
            questaoTextView.setText("Assinale a alternativa correta sobre as imagens tomográficas. ");
            a.setText("No processo de janelamento das imagens, os valores de número CT, expressos na escala de Hounsfield, não são alterados. ");
            b.setText("O número máximo de tons de cinza que pode ser exibido no monitor do equipamento é denominado nível de janela ou window level (WL). ");
            c.setText("A largura da janela ou window width (WW) representa o centro da escala de tons de cinza. ");
            d.setText("Uma escala longa de tons de cinza pode ser obtida com larguras de janelas (WW) maiores. ");
            e.setText("O janelamento para estruturas ósseas é obtido por meio da inclusão de baixos valores de número CT na escala de contraste. ");
            alt = R.id.d;
        }
        if (question == 75) {
            questaoTextView.setText("Sobre o Código de Ética dos Profissionais das Técnicas Radiológicas, definido nos termos da Resolução n° 15, de 12 de dezembro de 2011, do Conselho Nacional de Técnicos em Radiologia (CONTER), é correto afirmar que ");
            a.setText("o Código de Ética Profissional expõe os princípios éticos, os direitos e deveres, mas não trata das condutas necessárias para a prática da profissão de Tecnólogo, Técnico e Auxiliar de Radiologia. ");
            b.setText("é vedado ao profissional Tecnólogo, Técnico e Auxiliar de Radiologia fornecer ao cliente/paciente informações não específicas de sua formação. ");
            c.setText("o profissional de radiologia não deve se posicionar em situações de erros técnicos de demais profissionais da área. ");
            d.setText("os profissionais Tecnólogos, Técnicos e Auxiliares de Radiologia não são obrigados a prestar depoimentos em processo administrativo ou judicial sobre fatos que envolvam seus colegas e de que tenham conhecimento em razão do ambiente profissional. ");
            e.setText("no desempenho de suas funções profissionais, o Tecnólogo, o Técnico e o Auxiliar de radiologia podem executar técnicas radiológicas, radioterápicas, nuclear e industrial sem que haja requisição. ");
            alt = R.id.b;
        }
        if (question == 76) {
            questaoTextView.setText("De acordo com a Portaria n° 453, de 1 de junho de 1998, da Secretaria de Vigilância Sanitária do Ministério da Saúde, é correto afirmar que ");
            a.setText("não compete aos órgãos de Vigilância Sanitária dos Estados, do Distrito Federal e dos Municípios o licenciamento dos estabelecimentos que possuem os raios X diagnósticos. ");
            b.setText("a Portaria n°453/98 não atende à política nacional de proteção à saúde. ");
            c.setText("a limitação de doses individuais e a otimização da proteção radiológica são os únicos princípios básicos que regem a Portaria n°453/98. ");
            d.setText("a limitação de doses individuais não corresponde a um princípio de proteção radiológica. ");
            e.setText("toda a exposição que não pode ser justificada é proibida pela Portaria n°453/98. ");
            alt = R.id.e;
        }
        if (question == 77) {
            questaoTextView.setText("Assinale a alternativa INCORRETA de acordo com os Princípios e Diretrizes do Sistema Único de Saúde (SUS). ");
            a.setText("Os princípios doutrinários que regem o SUS se baseiam nos preceitos constitucionais. ");
            b.setText("A Universalidade não está entre as doutrinas e princípios do SUS. ");
            c.setText("A Resolubilidade e a Descentralização são princípios que regem a organização do SUS. ");
            d.setText("A contratação de serviços privados é permitida mediante a insuficiência do setor público. ");
            e.setText("O Princípio da Equidade assegura que todo cidadão é igual perante o SUS.");
            alt = R.id.b;
        }
        if (question == 78) {
            questaoTextView.setText("Os operadores de equipamentos de raios x devem entender necessariamente a relação entre os fatores geométricos e a qualidade das imagens produzidas durante o exercício de suas atividades. Acerca deste assunto, a melhor combinação entre os fatores geométricos para produzir imagens de boa qualidade, com mais detalhes e melhor resolução é ");
            a.setText("ponto focal maior, distância foco filme menor (DFOFI) e filamento menor (mA). ");
            b.setText("ponto focal menor, distância foco filme maior e distância objeto filme maior (DOF). ");
            c.setText("ponto focal menor, distância foco filme maior (DFOFI) e distância objeto filme menor (DOF). ");
            d.setText("ponto focal maior, distância foco filme menor e distância objeto filme maior (DOF). ");
            e.setText("ponto focal maior, distância foco filme menor e filamento maior. ");
            alt = R.id.c;
        }
        if (question == 79) {
            questaoTextView.setText("Para a realização de um exame radiográfico, foram usados 80 Kvp e 40mAs. Sendo o filamento 40 mA e o tempo 1 segundo. Sabe-se que o fator mAs é a exposição ou dose de radiação. Os mesmos 40mAs podem ser obtidos a partir do uso do filamento 400 mA e tempo de 0,1 segundo, estes produzirão a mesma exposição. Qual das situações apresentadas minimizará a movimentação do paciente, porém a imagem terá perda nos detalhes? ");
            a.setText("Em ambas as situações a dose de radiação será a mesma, portanto as chances de movimentos serão as mesmas. ");
            b.setText("A dose de radiação será a mesma, porém o movimento e perda de detalhes poderão ocorrer na segunda situação. ");
            c.setText("O movimento poderá ocorrer quando selecionado o filamento 40mA e 1 segundo perdendo detalhes na imagem. ");
            d.setText("Na segunda situação, o paciente não terá chances de movimentar-se, porém a imagem perderá detalhes. ");
            e.setText("Na primeira situação, o paciente terá chances de movimentar-se, porém a imagem perderá detalhes. ");
            alt = R.id.d;
        }
        if (question == 80) {
            questaoTextView.setText("Referente ao ponto focal no tubo de raios, assinale a alternativa INCORRETA. ");
            a.setText("É usado ponto focal menor quando necessitamos de imagens médicas com mais detalhes e boa resolução. ");
            b.setText("Representa a área de incidência ou menor ponto onde os elétrons atingem o ânodo e são produzidos os raios x. ");
            c.setText("É a região de choque dos elétrons e normalmente utilizamos pontos focais maiores quando precisamos de aquisições de imagens médicas com poucos detalhes e baixa resolução com tempo maior de exposição. ");
            d.setText("É a região de choque dos elétrons e normalmente utiliza-se pontos focais maiores quando precisamos de aquisições de imagens médicas com pouco detalhes e baixa resolução com tempo menor de exposição. ");
            e.setText("É usado ponto focal maior quando necessitamos de imagens médicas com menos detalhes e pouca resolução. ");
            alt = R.id.c;
        }
        if (question == 81) {
            questaoTextView.setText("Os equipamentos de raios x, em geral, possuem 2 tipos de ânodos: o fixo ou o giratório. Referente ao assunto, assinale a alternativa correta. ");
            a.setText("O ânodo fixo é utilizado na radiologia convencional por ter maior facilidade de dissipar o calor produzido durante o choque dos elétrons no alvo, fornecendo assim maior área de impacto aos elétrons. ");
            b.setText("O ânodo giratório é utilizado na radiologia convencional por facilitar a dissipação do calor produzido durante o choque dos elétrons no alvo, fornecendo assim maior área de impacto aos elétrons no alvo de tungstênio. ");
            c.setText("O ânodo giratório é utilizado na radiologia convencional por facilitar dissipação do calor produzido durante o choque dos elétrons no alvo, fornecendo assim menor área de impacto aos elétrons no alvo de tungstênio. ");
            d.setText("O ânodo giratório é utilizado na radiologia convencional por facilitar dissipação do calor produzido durante o choque dos elétrons no alvo, fornecendo assim maior área de impacto aos elétrons no filamento do tubo de raios x. ");
            e.setText("O ânodo fixo é utilizado na radiologia odontológica por ter maior facilidade de dissipar o calor produzido durante o choque dos elétrons no alvo, fornecendo assim maior área de impacto aos elétrons e utilização de energias maiores.");
            alt = R.id.b;
        }
        if (question == 82) {
            questaoTextView.setText("Um dos fenômenos que tem relação com a qualidade da imagem em radiologia é o efeito anódico. Sobre o efeito anódico, assinale a alternativa correta. ");
            a.setText("Durante a instalação de um equipamento de raios x na sala, o pólo negativo ânodo deve estar voltado para a estativa, assim sendo aproveitamos melhor este fenômeno durante os exames radiográficos. ");
            b.setText("Durante a instalação de um equipamento de raios x na sala, o pólo negativo cátodo deve estar oposto à estativa, assim sendo aproveitamos melhor este fenômeno durante os exames radiográficos. ");
            c.setText("Durante a instalação de um equipamento de raios x na sala, o pólo negativo cátodo deve estar voltado para a estativa, assim sendo aproveitamos melhor este fenômeno durante os exames radiográficos. ");
            d.setText("Durante a instalação de um equipamento de raios x na sala, os pólos ânodo e cátodo não tem relação com imagem e a estativa, assim sendo, não influenciam nos exames radiográficos. ");
            e.setText("É o fenômeno em que a intensidade da radiação decresce conforme se aumenta a distância da fonte emissora de radiação e, portanto, a parte mais espessa deve ser colocada do lado do ânodo. ");
            alt = R.id.c;
        }
        if (question == 83) {
            questaoTextView.setText("Assinale a afirmação correta em relação às aplicações das seguintes radiações. ");
            a.setText("Na área da saúde para diagnóstico: raios X e gama. ");
            b.setText("Na área da saúde para terapia: raios X, gama e alfa. ");
            c.setText("Na área da indústria: raios-x, gama e alfa. ");
            d.setText("Na área da pesquisa: raios-x, alfa e gama. ");
            e.setText("Na área da agricultura: raios-x, beta e gama. ");
            alt = R.id.a;
        }
        if (question == 84) {
            questaoTextView.setText("Analise as assertivas e assinale a alternativa que aponta as correta, sobre o uso dos écrans utilizados na radiologia. \n\rI. Aumentam a produção dos raios x e melhoram a qualidade da imagem produzida.\n\rII. Reduzem a dose de radiação durante os exames.\n\rIII. Durante a exposição, ocorre a fosforescência que transforma raios X em luz visível.\n\rIV. Durante a exposição, ocorre a fluorescência que transforma raios X em luz visível.\n\rV. Aumentam a vida útil das ampolas de raios x.  ");
            a.setText("Apenas I, II e V ");
            b.setText("Apenas I, II, IV e V. ");
            c.setText("Apenas II, III e V. ");
            d.setText("Apenas II, III, IV e V. ");
            e.setText("Apenas II, IV e V. ");
            alt = R.id.e;
        }
        if (question == 85) {
            questaoTextView.setText("A exposição a fontes de radiação ionizante pode induzir o surgimento de dano ao tecido biológico em indivíduos. Os efeitos da radiação que ocorrem no indivíduo exposto e precisam de limiar de dose denominam-se ");
            a.setText("Somáticos. ");
            b.setText("Genéticos. ");
            c.setText("Determinísticos. ");
            d.setText("De interação ");
            e.setText("Estocásticos. ");
            alt = R.id.c;
        }
        if (question == 86) {
            questaoTextView.setText("As exposições médicas ");
            a.setText("são exposições de indivíduos em decorrência do seu trabalho. ");
            b.setText("são exposições de pacientes em decorrência de exames, e de acompanhantes que ajudam a conter o paciente. ");
            c.setText("são exposições de médicos envolvidos em atividades que fazem o uso das radiações ionizantes. ");
            d.setText("são exposições somente de pacientes em decorrência de solicitações médicas a exames radiológicos. ");
            e.setText("são as exposições de todos os profissionais envolvidos em atividades com radiação ionizantes.");
            alt = R.id.b;
        }
        if (question == 87) {
            questaoTextView.setText("De acordo com a norma CNEN-NN-3.01 “Diretrizes Básicas de Proteção Radiológica”, o limite anual de doses para extremidades em indivíduos ocupacionalmente expostos é igual a ");
            a.setText("150 mSv/ano ");
            b.setText("50 mSv/ano ");
            c.setText("20 mSv/ano ");
            d.setText("1 mSv/ano ");
            e.setText("500 mSv/ano ");
            alt = R.id.e;
        }
        if (question == 88) {
            questaoTextView.setText("As bombas de cobalto-60 e Irídio-192 são materiais que possuem radioatividade, emitem radiação constantemente, independente da nossa vontade, e são usadas para radioterapia. Em relação à fonte selada de radiação, é correto afirmar que ");
            a.setText("não há contato físico entre o material radioativo e ambiente, estas oferecem riscos de irradiação e contaminação. ");
            b.setText("a fonte está fechada dentro de um invólucro robusto que impede o escape de material radioativo, nessas condições existe o risco de contaminação e de irradiação. ");
            c.setText("o material radioativo está sob a forma líquida ou de pó em recipientes abertos e encontra-se exposto ao contato. ");
            d.setText("ela apresenta o risco de irradiação e contaminação, como os aparelhos de raios x diagnósticos. ");
            e.setText("a fonte está fechada dentro de um invólucro robusto que impede o escape de material radioativo que, em condições normais, apresenta apenas o risco de irradiação. ");
            alt = R.id.e;
        }
        if (question == 89) {
            questaoTextView.setText("A radioproteção se baseia em princípios e diretrizes conforme a recomendação das normas da Comissão Nacional de Energia Nuclear (CNEN). O princípio que rege todos os princípios da radioproteção é a ");
            a.setText("justificação da prática e das exposições em atividades que usem radiação ionizante. ");
            b.setText("otimização da proteção radiológica pensando em doses menores. ");
            c.setText("limitação individual de doses equivalentes e efetivas para profissionais. ");
            d.setText("prevenção de acidentes. ");
            e.setText("ALARA. ");
            alt = R.id.e;
        }
        if (question == 90) {
            questaoTextView.setText("A anatomia radiográfica visualizada na projeção axial (súpero inferior) de ombro demonstra as seguintes estruturas: ");
            a.setText("acrômio, clavícula, processo coronoide, colo cirúrgico, trocanter maior, trocanter menor, cabeça do úmero e espinha da escápula. ");
            b.setText("acrômio, clavícula, processo coronoide, trocanter maior, trocanter menor, cabeça do úmero e espinha da escápula. ");
            c.setText("acrômio, clavícula, processo coracoide, colo anatômico, cavidade glenoide, tubérculo maior, cabeça do úmero e espinha da escápula. ");
            d.setText("acrômio, clavícula, processo coronoide, cavidade glenoide, trocanter maior, trocanter menor, cabeça do úmero e corpo da escápula. ");
            e.setText("acrômio, clavícula, processo coracoide, cavidade glenoide, tubérculo maior, sulco intertubercular, tubérculo menor, cabeça do úmero e espinha da escápula. ");
            alt = R.id.e;
        }
        if (question == 91) {
            questaoTextView.setText("A anatomia radiográfica visualizada na projeção ínferosuperior da patela apresenta as seguintes estruturas: ");
            a.setText("tubérculos da eminência intercondilar, fíbula, epicôndilo medial do fêmur, epicôndilo lateral do fêmur e patela. ");
            b.setText("côndilo medial da tíbia, côndilo lateral da tíbia e patela. ");
            c.setText("tubérculos da eminência intercondilar, tíbia, côndilo medial do fêmur, côndilo lateral do fêmur e patela. ");
            d.setText("tubérculos da eminência intercondilar, tíbia, côndilo medial do fêmur, côndilo lateral do fêmur e patela. ");
            e.setText("côndilo medial do fêmur, côndilo lateral do fêmur e patela. ");
            alt = R.id.e;
        }
        if (question == 92) {
            questaoTextView.setText("Das estruturas apresentadas a seguir, assinale a alternativa que apresenta as que fazem parte do diencéfalo. ");
            a.setText("Metatálamo, subtálamo e mesencéfalo. ");
            b.setText("Hipotálamo, tálamo e epitálamo. ");
            c.setText("Tálamo, mesencéfalo e giro do cíngulo. ");
            d.setText("Epitálamo, hipófise e giro do cíngulo. ");
            e.setText("Hipotálamo, tálamo e hipófise.");
            alt = R.id.b;
        }
        if (question == 93) {
            questaoTextView.setText("O espaço localizado entre a dura-máter e o periósteo, utilizado para aplicação de anestesia, é denominado ");
            a.setText("subaracnoideo. ");
            b.setText("peridural. ");
            c.setText("subdural. ");
            d.setText("subaracnoideo e subdural. ");
            e.setText("corticoespinal. ");
            alt = R.id.b;
        }
        if (question == 94) {
            questaoTextView.setText("O esqueleto axial é composto de 80 ossos e o esqueleto apendicular é composto por 126 ossos. Em relação ao assunto, analise as assertivas e assinale a alternativa que aponta a(s) correta(s). \n\r I. Os ossos da coluna sacral e cóccix estão localizados no esqueleto apendicular.\n\r II. Os ossos como a sínfise púbica, occipital e esterno pertencem ao esqueleto axial. \n\r III. Os ossos do carpo da fileira proximal são escafoides, semilunar piramidal e pisiforme. \n\r IV. Os ossos do carpo da fileira distal são escafoides, semilunar piramidal e pisiforme.  ");
            a.setText("Apenas II e III. ");
            b.setText("Apenas I. ");
            c.setText("Apenas III e IV. ");
            d.setText("Apenas III. ");
            e.setText("Apenas IV. ");
            alt = R.id.d;
        }
        if (question == 95) {
            questaoTextView.setText("A radioterapia de intensidade modulada (da sigla em inglês IMRT - Intensity- Modulated Radiation Therapy ) é a forma mais nova de radioterapia 3D. A IMRT algumas vezes é chamada de “pintura da dose”. Referente ao assunto, assinale a alternativa correta. ");
            a.setText("Na IMRT, o tratamento é associado ao tratamento primário para pacientes com doença localizada. ");
            b.setText("Na IMRT, o tratamento associado ao tratamento secundário para pacientes com metástases. ");
            c.setText("Na IMRT, a fonte de radiação situa-se próximo do paciente, tal como um feixe de raios x. ");
            d.setText("A IMRT é uma terapia adjuvante realizada antes da cirurgia curativa. ");
            e.setText("A IMRT se difere da radioterapia adaptada pelo fato de liberar doses diferentes em cada microfeixe para formar cada um dos campos adaptados. ");
            alt = R.id.e;
        }
        if (question == 96) {
            questaoTextView.setText("Os acessórios de imobilização em radioterapia são fundamentais durante as sessões de terapia. Os suportes têm por objetivo posicionar a coluna cervical de acordo com cada proposta de tratamento. São construídos com formatos padronizados e identificados por letras. O enunciado refere-se a ");
            a.setText("máscaras termoplásticas. ");
            b.setText("suportes para cabeça e pescoço. ");
            c.setText("retrator de ombros. ");
            d.setText("breast board. ");
            e.setText("belly board.");
            alt = R.id.b;
        }
        if (question == 97) {
            questaoTextView.setText("Sobre as técnicas de tratamento e posicionamento de pacientes na radioterapia, é correto afirmar que ");
            a.setText("a radioterapia utiliza a combinação de campos para irradiar o volume alvo com base na dose prescrita pelo radioterapeuta, minimizando os danos aos tecidos sadios. Já o posicionamento incorreto pode acarretar no comprometimento dos resultados esperados, podendo também causar sérios danos ao paciente, como a subdosagem. ");
            b.setText("a radioterapia utiliza a combinação de campos para irradiar o volume alvo com base na dose prescrita pelo radioterapeuta, minimizando os danos aos tecidos sadios. Já o posicionamento incorreto pode acarretar comprometimento dos resultados esperados podendo também causar sérios danos ao paciente como a subdosagem e a sobredosagem. ");
            c.setText("a radioterapia utiliza a combinação de campos para irradiar o volume alvo com base na dose prescrita pelo radioterapeuta, minimizando os danos aos tecidos sadios. Já o posicionamento incorreto pode acarretar no comprometimento dos resultados esperados, podendo também causar sérios danos ao paciente, como a sobredosagem. ");
            d.setText("a radioterapia de intensidade modulada é igual a radioterapia adaptada, pelo fato de liberar doses diferentes em cada microfeixe para formar cada um dos campos adaptados. ");
            e.setText("a IMRT se difere da radioterapia adaptada pelo fato de serem liberadas doses iguais em cada feixe para formar cada um dos campos adaptados. ");
            alt = R.id.b;
        }
        if (question == 98) {
            questaoTextView.setText("A fonte de radiação situa-se distante do tumor do paciente, tal como um feixe de raios x. O enunciado refere-se à ");
            a.setText("braquiterapia. ");
            b.setText("localização. ");
            c.setText("radioterapia adaptada. ");
            d.setText("teleterapia. ");
            e.setText("curva de isodose. ");
            alt = R.id.d;
        }
        if (question == 99) {
            questaoTextView.setText("Em relação aos princípios e diretrizes do Sistema Único de Saúde (SUS) referente ao princípio doutrinário da equidade, assinale a alternativa correta. ");
            a.setText("Este princípio prega o acesso de todas as pessoas aos serviços na área da saúde pelo estado, independente de sexo, raça, ocupação, classe social ou qualquer outra característica individual e social. ");
            b.setText("Este princípio diz respeito à justiça social, sem vinculação de privilégio a nenhuma pessoa. ");
            c.setText("Este princípio representa, para alguns estudiosos, um dos maiores avanços na área da saúde, levando em conta todas as necessidades do indivíduo ou grupo. ");
            d.setText("Este princípio prega o acesso de todas as pessoas aos serviços na área da saúde pelo estado, município e distrito federal, dependendo da característica individual e social. ");
            e.setText("Este princípio prega a universalização no atendimento às pessoas aos serviços na área da saúde. ");
            alt = R.id.b;
        }
        if (question == 100) {
            questaoTextView.setText("Sobre a vigilância sanitária, assinale a alternativa correta. ");
            a.setText("É um conjunto de ações capaz de eliminar, diminuir ou prevenir riscos a saúde e de intervir nos problemas sanitários decorrentes do meio ambiente, da produção e circulação de bens e da prestação de serviços de interesses da saúde. ");
            b.setText("É um conjunto de ações capaz de prevenir riscos à saúde e de intervir nos problemas sanitários decorrentes do meio ambiente, da produção e circulação de bens e da prestação de serviços de interesses da saúde. ");
            c.setText("É um conjunto de ações capaz de eliminar riscos à saúde e de intervir nos problemas sanitários decorrentes do meio ambiente e da prestação de serviços de interesses da saúde. ");
            d.setText("É um conjunto de ações capaz de diminuir ou prevenir riscos à saúde decorrentes do meio ambiente, da produção e circulação de bens e da prestação de serviços sem interesses da saúde. ");
            e.setText("É um conjunto de ações capaz de erradicar riscos à saúde, sem intervir nos problemas sanitários decorrentes do meio ambiente, da produção e circulação de bens e da prestação de serviços de interesses da saúde. ");
            alt = R.id.a;
        }
        if (question == 101) {
            questaoTextView.setText("Com relação às instituições privadas de assistência à saúde no Sistema Único de Saúde, é correto afirmar que ");
            a.setText("exercem um papel essencial. ");
            b.setText("devem ser extintas progressivamente. ");
            c.setText("podem participar de forma complementar. ");
            d.setText("tiveram seus direitos assegurados, sendo vetado o surgimento de novas iniciativas. ");
            e.setText("podem participar de forma primária.");
            alt = R.id.c;
        }
        if (question == 102) {
            questaoTextView.setText("Referente ao(s) objetivo(s) do Sistema Único de Saúde (SUS), analise as assertivas e assinale a alternativa que aponta a(s) correta(s). \n\rI. A identificação e divulgação dos fatores condicionantes e determinantes da saúde. \n\rII. A formulação de política de saúde destinada a promover, nos campos econômico e social, a observância do disposto no § 1º do art. 2º da lei nº 8080/90. \n\rIII. A assistência às pessoas por intermédio de ações de promoção, proteção e recuperação da saúde, sem a realização integrada das ações assistenciais e das atividades preventivas. ");
            a.setText("Apenas I. ");
            b.setText("Apenas I e III. ");
            c.setText("I, II e III. ");
            d.setText("Apenas I e II. ");
            e.setText("Apenas II e III.");
            alt = R.id.d;
        }
        if (question == 103) {
            questaoTextView.setText("Assinale a alternativa que NÃO condiz com um exame de tomografia computadorizada helicoidal.");
            a.setText("Devido à grande velocidade de aquisição de imagens, se faz necessário o uso de bombas infusoras.");
            b.setText("O sistema de interpolação não altera o valor da espessura de corte que foi utilizada para adquirir as imagens iniciais.");
            c.setText("O processo de interpolação de reconstrução de imagens irá proporcionar um menor número de imagens, melhorando sua resolução.");
            d.setText("O pré-delay irá estabelecer o tempo de início de corte do scanner, sendo nele incluído o tempo do comando de inspiração quando estabelecido para o exame.");
            e.setText("A interpolação é um processo do sistema que utiliza uma convolução matemática que irá reconstruir uma imagem, obtendo dados de duas outras imagens adjacentes.");
            alt = R.id.c;
        }
        if (question == 104) {
            questaoTextView.setText("São ossos que compõem o crânio (ossos cranianos):");
            a.setText("Parietal, frontal e occipital.");
            b.setText("Temporal, frontal e occipital.");
            c.setText("Parietal, temporal e occipital.");
            d.setText("Temporal, parietal, occipital, frontal e esfenoide.");
            e.setText("Parietal, occipital, frontal, temporal, esfenoide e etmoide.");
            alt = R.id.e;
        }
        if (question == 105) {
            questaoTextView.setText("Em tomografia computadorizada, existem opções de posicionamento do paciente de grande relevância para o início do exame. Assinale a INCORRETA.");
            a.setText("Supino position: paciente está em decúbito dorsal.");
            b.setText("Prone position: paciente está em decúbito ventral.");
            c.setText("Feet first: paciente está com os pés direcionados para o gantry.");
            d.setText("Feet first: paciente está com os pés voltados para fora do gantry.");
            e.setText("Head first: paciente está com a cabeça direcionada para o gantry.");
            alt = R.id.d;
        }
        if (question == 106) {
            questaoTextView.setText("Para montar um protocolo de tomografia, é INCORRETO");
            a.setText("definir KV, MA e tempo.");
            b.setText("selecionar intervalo de corte.");
            c.setText("selecionar espessura de corte-voxel.");
            d.setText("definir área anatômica a ser estudada.");
            e.setText("medir o menor diâmetro da imagem e definir FOV.");
            alt = R.id.e;
        }
        if (question == 107) {
            questaoTextView.setText("Qual unidade e grandeza de dose absorvida corresponde a 1 Gray?");
            a.setText("1 rad.");
            b.setText("100 rad.");
            c.setText("100 rem.");
            d.setText("100 Sievert.");
            e.setText("1 becquerel.");
            alt = R.id.b;
        }
        if (question == 108) {
            questaoTextView.setText("Os equipamentos de radiodiagnósticos devem ser mantidos em condições adequadas de funcionamento e submetidos, regularmente, a verificações periódicas. São testes recomendados anualmente, EXCETO:");
            a.setText("Rendimento do tubo.");
            b.setText("Exatidão do indicador de tensão do tubo.");
            c.setText("Linearidade da taxa kerma no ar com mAs.");
            d.setText("Alinhamento do eixo central do feixe de raio-x.");
            e.setText("Valores representativos da taxa de dose ao paciente em fluoroscopia e do  tempo do exame ou do produto dose-área.");
            alt = R.id.e;
        }
        if (question == 109) {
            questaoTextView.setText("Em uma incidência pélvica AP, quadril bilateral em decúbito dorsal, o raio central incide perpendicular ao filme e próximo à sínfise púbica. Qual das  estruturas NÃO é visualizada neste exame?");
            a.setText("Colo femoral.");
            b.setText("Trocanter maior.");
            c.setText("Côndilos femorais.");
            d.setText("Forame obturador.");
            e.setText("Tuberosidade isquiática.");
            alt = R.id.c;
        }
        if (question == 110) {
            questaoTextView.setText("Em uma incidência bilateral de joelhos AP com carga em um paciente magro, como o raio central deverá incidir com relação ao filme?");
            a.setText("Perpendicular.");
            b.setText("5 a 10 graus caudal.");
            c.setText("5 a 10 graus cranial.");
            d.setText("10 a 20 graus caudal.");
            e.setText("10 a 20 graus cranial.");
            alt = R.id.b;
        }
        if (question == 111) {
            questaoTextView.setText("A faringe é uma via de passagem tanto de alimentos sólidos e líquidos, quanto do ar. Embora seja comum aos sistemas respiratório e digestivo, possui nomenclaturas diferentes. Diante do exposto, assinale a alternativa correta.");
            a.setText("Orofaringe, nasofaringe e tireofaringe.");
            b.setText("Nasofaringe, orofaringe e laringofaringe.");
            c.setText("Mentofaringe, orofaringe e tireofaringe.");
            d.setText("Orofaringe, mentofaringe e tireofaringe.");
            e.setText("Nasofaringe, tireofaringe e laringofaringe.");
            alt = R.id.b;
        }
        if (question == 112) {
            questaoTextView.setText("Qual das contraindicações para um exame de ressonância magnética apresenta-se INCORRETA?");
            a.setText("Marca-passo.");
            b.setText("Prótese metálica.");
            c.setText("Projétil de arma de fogo.");
            d.setText("Angioplastia com colocação de stend.");
            e.setText("Ruptura do ligamento cruzado anterior.");
            alt = R.id.e;
        }
        if (question == 113) {
            questaoTextView.setText("Em uma incidência da coluna torácica, em AP e decúbito dorsal, como o raio central deve incidir com relação ao filme e à anatomia do paciente, respectivamente?");
            a.setText("Perpendicular ao filme e centralizado em T5.");
            b.setText("20 graus de inclinação cranial e centralizado em T5.");
            c.setText("20 graus de inclinação cranial e centralizado em T7.");
            d.setText("Perpendicular ao filme e centralizado em T7 de 3 a 5 cm acima da incisura jugular.");
            e.setText("Perpendicular ao filme e centralizado em T7 de 3 a 5 cm abaixo do ângulo esternal.");
            alt = R.id.e;
        }
        if (question == 114) {
            questaoTextView.setText("Vários fatores determinam a velocidade de um écran, sendo correto afirmar que é um produto da absorção e conversão, ou seja, conversão do raio-x em luz visível. Assinale a afirmativa que NÃO apresenta um fator que influencia na velocidade de um écran.");
            a.setText("Tamanho do cristal fosfórico.");
            b.setText("Espessura da camada fosfórica.");
            c.setText("Isolamento da camada fosfórica.");
            d.setText("Composição do material fosfórico.");
            e.setText("Concentração do material fosfórico.");
            alt = R.id.c;
        }
        if (question == 115) {
            questaoTextView.setText("Em uma cintilografia hepática com uma gama câmara com apenas uma cabeça, quais são os posicionamento desta em relação ao paciente?");
            a.setText("Anterior e posterior.");
            b.setText("Posterior e lateral direita.");
            c.setText("Anterior e lateral esquerda.");
            d.setText("Posterior e lateral esquerda.");
            e.setText("Anterior, posterior, lateral direita e lateral esquerda.");
            alt = R.id.e;
        }
        if (question == 116) {
            questaoTextView.setText("Sobre um procedimento de descontaminação externa, assinale a afirmativa INCORRETA.");
            a.setText("Esfregar sem exagero para não ferir a pele.");
            b.setText("Lavar as áreas do corpo alcançadas pela contaminação.");
            c.setText("Usar água e sabão neutro ou produto descontaminante disponível.");
            d.setText("Monitorar de tempo em tempo para verificar a eficiência do procedimento.");
            e.setText("Encaminhar ao médico para avaliação de dose e medidas necessárias para eliminação do contaminante.");
            alt = R.id.e;
        }
        if (question == 117) {
            questaoTextView.setText("Qual é a meia-vida do iodo-131?");
            a.setText("6 dias.");
            b.setText("8 dias.");
            c.setText("6 horas.");
            d.setText("8 horas.");
            e.setText("12 horas.");
            alt = R.id.b;
        }
        if (question == 118) {
            questaoTextView.setText("Qual dos aparelhos relacionados NÃO é utilizado em medicina nuclear?");
            a.setText("Curiômetro.");
            b.setText("Gama câmara.");
            c.setText("Sonda de captação.");
            d.setText("Monitor de superfície.");
            e.setText("Acelerador linear de partículas.");
            alt = R.id.e;
        }
        if (question == 119) {
            questaoTextView.setText("Em relação aos rejeitos radioativos, assinale a afirmativa INCORRETA.");
            a.setText("O local de decaimento deve ser blindado.");
            b.setText("Separar sempre os rejeitos líquidos dos sólidos.");
            c.setText("Estocar as agulhas separadas para picotar ou queimá-las.");
            d.setText("A área de depósito deve ser identificada com o símbolo internacional de radiação na porta.");
            e.setText("Todos os rejeitos radioativos devem ser armazenados para decaimento, identificados e acondicionados, de maneira a garantir sua integridade durante o tempo de decaimento.");
            alt = R.id.b;
        }
        if (question == 120) {
            questaoTextView.setText("Assinale a alternativa que apresenta os ossos do carpo.");
            a.setText("Escafoide, talus, trapézio trapezoide, semilunar e capitato hamato.");
            b.setText("Escafoide, navicular, trapézio, capitato, hamato, semilunar e psiforme.");
            c.setText("Escafoide, navicular, capitato, hamato, trapézio, trapezoide e piramidal.");
            d.setText("Escafoide, capitato, hamato, piramidal, psiforme, trapézio e trapezoide.");
            e.setText("Escafoide, semilunar, capitato, hamato, piramidal, psiforme, trapézio e trapezoide.");
            alt = R.id.e;
        }
        if (question == 121) {
            questaoTextView.setText("Quais das estruturas relacionadas consistem no romboencéfalo?");
            a.setText("Ponte, bulbo e cerebelo.");
            b.setText("Bulbo, infundíbulo e ponte.");
            c.setText("Cerebelo, corpo caloso e bulbo.");
            d.setText("Corpo caloso, bulbo e cerebelo.");
            e.setText("Cerebelo, ponte e mesencéfalo.");
            alt = R.id.a;
        }
        if (question == 122) {
            questaoTextView.setText("O esqueleto apendicular adulto do ser humano é composto de quantos ossos separados?");
            a.setText("204.");
            b.setText("206.");
            c.setText("212.");
            d.setText("214.");
            e.setText("216.");
            alt = R.id.b;
        }
        if (question == 123) {
            questaoTextView.setText("Em relação à radioproteção, de acordo com a Norma 3.05 da Comissão Nacional de Energia Nuclear, assinale a afirmativa INCORRETA.");
            a.setText("Deve ser feito um levantamento radiométrico trimestralmente nas áreas restritas.");
            b.setText("Os trabalhadores envolvidos na manipulação dos radiofármacos devem usar luvas descartáveis e avental.");
            c.setText("Deve ser realizado ao fim da jornada de trabalho com monitor de contaminação uma monitoração das superfícies, mãos e luvas.");
            d.setText("A manipulação do radiofármaco deve ser feita em uma bancada lisa de fácil descontaminação, recoberta com plástico e papel absorvente.");
            e.setText("O material radioativo, ao chegar no serviço, deve ser monitorado externamente e os resultados confrontados com os valores registrados na guia de monitoração que acompanha o material.");
            alt = R.id.a;
        }
        if (question == 124) {
            questaoTextView.setText("Assinale a sequência correta do corpo humano, do mais simples para o mais complexo, em relação à organização estrutural.");
            a.setText("Molécula, átomo, tecido, célula, órgão, sistema e organismo.");
            b.setText("Molécula, átomo, célula, tecido, sistema, órgão e organismo.");
            c.setText("Átomo, molécula, tecido, célula, órgão, organismo e sistema.");
            d.setText("Átomo, molécula, célula, tecido, sistema, órgão e organismo.");
            e.setText("Átomo, molécula, célula, tecido, órgão, sistema e organismo.");
            alt = R.id.e;
        }
        if (question == 125) {
            questaoTextView.setText("Assinale a alternativa que NÃO constitui uma responsabilidade do supervisor de radioproteção.");
            a.setText("Garantir o cumprimento dos requisitos básicos de proteção radiológica.");
            b.setText("Determinar o responsável técnico e exigir o cumprimento de suas obrigações.");
            c.setText("Auxiliar e informar a direção da instalação sobre todos os assuntos relativos à proteção radiológica.");
            d.setText("Planejar, coordenar, implementar e supervisionar as atividades do serviço com relação à radioproteção.");
            e.setText("Coordenar o treinamento, orientar e avaliar o desempenho dos trabalhadores sob o ponto de vista de proteção radiológica.");
            alt = R.id.b;
        }
        if (question == 126) {
            questaoTextView.setText("Um tecnólogo em radiologia tem como atribuição fornecer uma radiografia com qualidade e nitidez. De acordo com as técnicas de radiografia, assinale a alternativa correta em relação à tensão (kV) e à corrente (mA).");
            a.setText("A tensão (kV) depende, exclusivamente, da corrente (mA).");
            b.setText("A tensão (kV) é responsável pelo contraste.");
            c.setText("A tensão (kV) não pode ser calculada.");
            d.setText("O tempo de exposição determina a qualidade de raios X produzidos.");
            e.setText("A corrente (mA) é responsável pela espessura da região radiografada.");
            alt = R.id.b;
        }
        if (question == 127) {
            questaoTextView.setText("Alguns fatores influenciam as técnicas radiográficas. A esse respeito, assinale a alternativa que indica os fatores que afetam as técnicas radiológicas.");
            a.setText("A mudança de tensão (kV) afeta no poder de penetração dos raios X.");
            b.setText("O filtro que vai acoplado ao cabeçote elimina a radiação de alta energia.");
            c.setText("A imobilização é dispensável durante a exposição ao raios X.");
            d.setText("Quanto maior a distância objeto-filme (DOF) menor será a imagem do órgão radiografado.");
            e.setText("A distância foco-objeto (DFO) não interfere nos efeitos nocivos dos raios X.");
            alt = R.id.a;
        }
        if (question == 128) {
            questaoTextView.setText("A exposição de pacientes a exames de raios X requer conhecimento específico e adequado por parte dos tecnólogos. A respeito das técnicas em radiologia, assinale a alternativa que melhor indica o que é a linha de Reid.");
            a.setText("Incidência mais adequada para estudo e avaliação do forame Magno.");
            b.setText("Linha que serve como referência no posicionamento do crânio.");
            c.setText("Incidência mais adequada para estudar os processos clinoides posteriores.");
            d.setText("Linha que serve como referência no posicionamento da perna.");
            e.setText("Incidência mais adequada para radiografia panorâmica.");
            alt = R.id.b;
        }
        if (question == 129) {
            questaoTextView.setText("A radiação propaga-se sob forma de ondas eletromagnéticas, transportando energia. Acerca do tema, assinale a alternativa que indica a mais penetrante no tecido humano.");
            a.setText("Radiação gama, com feixe de baixa intensidade.");
            b.setText("Íon pesado, em forma de feixe fino.");
            c.setText("Radiação alfa, proveniente de fonte de alta atividade.");
            d.setText("Radiação beta, com feixe colimado e intenso.");
            e.setText("Fragmento de fissão de grande massa, de 140 MeV de energia.");
            alt = R.id.a;
        }
        if (question == 130) {
            questaoTextView.setText("Os raios X foram descobertos em 8 de novembro de 1895, pelo professor de física teórica, Wilhelm Conrad Röentgen, o que ocorreu em razão das experiências com ampolas de Hittorf e Crookes. De acordo com a produção de raios X, assinale a alternativa que apresenta um componente de um gerador de raios X.");
            a.setText("Câmara de ionização.");
            b.setText("Eletrômetro.");
            c.setText("Barômetro.");
            d.setText("Anodo e catodo.");
            e.setText("Câmara de placas paralelas.");
            alt = R.id.d;
        }
        if (question == 131) {
            questaoTextView.setText("Irídio é o nome dado ao elemento químico de símbolo Ir, cujo número atômico é 77 e a massa atômica é 192,2 u. Na tabela periódica, está posicionado entre os metais de transição, e na natureza encontra-se em estado sólido. É utilizado para tratamento de câncer. Sabendo que sua meia-vida é de aproximadamente 74 dias e que sua atividade inicial é de 800 GBq, assinale a alternativa que indica depois de quantos dias sua atividade será de 50 GBq.");
            a.setText("74 dias.");
            b.setText("148 dias.");
            c.setText("222 dias.");
            d.setText("296 dias.");
            e.setText("370 dias.");
            alt = R.id.d;
        }
        if (question == 132) {
            questaoTextView.setText("Representa a distância da fonte de radiação até o eixo de rotação do aparelho (isocentro). Na prática clínica, consiste na determinação de um ponto em uma determinada profundidade no paciente, ao redor do qual o aparelho irá girar (isocentro). Com base no texto apresentado, é correto afirmar que a técnica descrita é");
            a.setText("GVT.");
            b.setText("PTV.");
            c.setText("SSD.");
            d.setText("SAD.");
            e.setText("CTV.");
            alt = R.id.d;
        }
        if (question == 133) {
            questaoTextView.setText("Os acessórios são extremamente úteis na imobilização para posicionamento dos pacientes, além de alguns servirem até mesmo para homogeneizar as curvas de isodoses, principalmente com tratamento de elétrons. A esse respeito, assinale a alternativa que melhor indica a função desse acessório em radioterapia.");
            a.setText("VacLock.");
            b.setText("Bólus.");
            c.setText("Retrator de pés.");
            d.setText("Suporte de joelhos.");
            e.setText("Pronpillow.");
            alt = R.id.b;
        }
        if (question == 134) {
            questaoTextView.setText("Localizar de forma mais precisa o tumor ou os órgãos internos acometidos no instante do tratamento, para que houvesse melhor correlação com as imagens de referência. Assinale a alternativa que melhor define a técnica utilizada em radioterapia descrita no texto apresentado.");
            a.setText("HDR.");
            b.setText("LDR.");
            c.setText("IMRT.");
            d.setText("BEV.");
            e.setText("IGRT.");
            alt = R.id.e;
        }
        if (question == 135) {
            questaoTextView.setText("A radioterapia guiada por imagem, conhecida como Image Guided Radiation Therapy (IGRT) permite a máxima reprodutibilidade de posicionamento do paciente. De acordo com essa técnica, assinale a alternativa que apresenta sua vantagem em relação às demais.");
            a.setText("Não há possibilidade de aplicar radiação com altíssima precisão.");
            b.setText("Não é necessário o sistema de planejamento.");
            c.setText("Com a IGRT, o alvo e os órgãos de risco do paciente são monitorados em tempo real.");
            d.setText("O tecnólogo não precisa operar mais as máquinas de tratamento.");
            e.setText("A técnica é uma modalidade da radioterapia na qual a fonte de radiação está em contato ou muito próxima à área tratada.");
            alt = R.id.c;
        }
        if (question == 136) {
            questaoTextView.setText("As Normas da Comissão Nacional de Energia Nuclear (CNEN) têm vários artigos que regem a proteção radiológica. Considerando as exposições de emergências, conforme a CNEN NN no. 3.01, assinale a alternativa correta.");
            a.setText("Quando as doses previstas não ultrapassem os limites primários, qualquer pessoa pode participar, desde que seja decidido diretamente pela direção da instalação.");
            b.setText("Quando as doses previstas forem inferiores a 100 mSv, qualquer pessoa pode decidir sobre sua participação, desde que previamente informada sobre os riscos associados.");
            c.setText("Quando as doses previstas sejam iguais ou superiores a 100 mSv, somente participem trabalhadores voluntários com informações prévias sobre os riscos associados.");
            d.setText("Desde que os sistemas de radioproteção da instalação estejam otimizados e as doses previstas minimizadas, qualquer trabalhador informado previamente sobre os riscos associados pode participar.");
            e.setText("Nos planos de radioproteção, não existem os de emergência.");
            alt = R.id.c;
        }
        if (question == 137) {
            questaoTextView.setText("As normas de radioproteção da Comissão Nacional de Energia Nuclear (CNEN) têm princípios básicos de proteção radiológica. Acerca do tema a alternativa que diz respeito ao princípio da justificação.");
            a.setText("O projeto, o planejamento do uso e a operação de instalação e de fontes de radiação devem ser feitos de modo a garantir que as exposições sejam tão reduzidas quanto razoavelmente exequível, considerando fatores sociais e econômicos.");
            b.setText("Qualquer atividade envolvendo radiação ou exposição deve ser justificada em relação a outras alternativas e produzir um benefício líquido positivo para a sociedade.");
            c.setText("As doses individuais de trabalhadores e de indivíduos do público não devem exceder os limites anuais de dose equivalente estabelecidos em norma.");
            d.setText("A redundância, em um sistema de segurança, consiste no uso de mais que o número mínimo de itens necessários para executar uma dada função de segurança.");
            e.setText("O isolamento funcional ou separação física de sistemas redundantes ou que possuam funções diversas e de mesmo grau de importância para a segurança.");
            alt = R.id.b;
        }
        if (question == 138) {
            questaoTextView.setText("Na radioterapia, o tratamento de pacientes é dado por dose absoluta, segundo os protocolos. Acerca do tema, assinale a alternativa que define, em termos conceituais, a dose absorvida da radiação em um tecido.");
            a.setText("A quantidade de radiação que um tecido humano absorveu.");
            b.setText("A relação entre a energia absorvida e o volume de absorção em um tecido.");
            c.setText("A relação entre a quantidade de radiação absorvida e o tempo gasto.");
            d.setText("A relação entre a energia transferida pela radiação e a massa onde ocorreu essa transferência no tecido.");
            e.setText("A relação entre a energia absorvida da radiação e a massa do volume onde ocorreu esta absorção em um tecido.");
            alt = R.id.e;
        }
        if (question == 139) {
            questaoTextView.setText("Considerando a braquiterapia, assinale a alternativa correta.");
            a.setText("Na braquiterapia, sempre são utilizados radioisótopos que são implantados na região do tumor.");
            b.setText("Cabe ao técnologo em radiologia calcular as doses diárias nos locais onde se tem braquiterapia.");
            c.setText("Braquiterapia intracavitária é aquela realizada com técnicas de implantes em cavidades.");
            d.setText("Na braquiterapia intracavitária de baixa taxa de dose, quando são colocadas fontes seladas no paciente, liberando energia ao longo de horas ou dias, é exigida a internação desse paciente.");
            e.setText("Na braquiterapia de alta taxa de dose, são usados exclusivamente para o conforto do paciente: travesseiros, rampas e suportes.");
            alt = R.id.d;
        }
        if (question == 140) {
            questaoTextView.setText("O tratamento com a técnica 3D conformacional trouxe grandes benefícios quando comparado com a radioterapia convencional 2D. A esse respeito, assinale a alternativa que melhor representa a vantagem da radioterapia conformacional.");
            a.setText("O planejamento de tratamento não pode ser realizado em um tomógrafo.");
            b.setText("A técnica conformacional é utilizada em procedimentos de braquiterapia com alta taxa de dose.");
            c.setText("A técnica conformacional usada em procedimentos de braquiterapia com baixa taxa de dose.");
            d.setText("Com a radioterapia 3D conformacional, é possível visualizar e delinear as estruturas a serem tratadas e os órgãos que devem ser protegidos.");
            e.setText("Não se podem utilizar vários campos na técnica 3D conformacional por não se ter segurança no tratamento.");
            alt = R.id.d;
        }
        if (question == 141) {
            questaoTextView.setText("A simulação do tratamento, a imobilização, o posicionamento, as proteções ao campo, o check film e o portal film são procedimentos padrões de qualquer tecnólogo em radiologia. A esse respeito, assinale a alternativa que indica a vantagem do check film digital (portal eletrônico) em relação ao convencional ou radiológico.");
            a.setText("Aquisição tardia de imagem.");
            b.setText("Independência eletrônica.");
            c.setText("Dependência de revelador.");
            d.setText("Custo baixo.");
            e.setText("Aquisição de múltiplas imagens.");
            alt = R.id.e;
        }
        if (question == 142) {
            questaoTextView.setText("São softwares utilizados para delineamento de órgãos e cálculo de tratamentos em radioterapia. Para realização de uma radioterapia de qualidade, eles são tão importantes quanto os aceleradores que produzem a radiação. É correto afirmar que o texto apresentado define");
            a.setText("acessório de imobilização.");
            b.setText("bólus.");
            c.setText("sistema de gerenciamento ou planejamento.");
            d.setText("tomografia computadorizada.");
            e.setText("STV.");
            alt = R.id.c;
        }
        if (question == 143) {
            questaoTextView.setText("Na radioterapia conformacional, a obtenção de imagens nítidas é indispensável para o planejamento médico. De acordo com seus conhecimentos em radioterapia, assinale a alternativa que melhor define a técnica de radioterapia conformacional 3D.");
            a.setText("São feitos apenas com um campo de tratamento todos os casos de tratamento com essa tecnologia.");
            b.setText("Essa tecnologia permite que mobilidade do paciente durante o tratamento.");
            c.setText("Consiste em conformar o feixe de radiação à região a ser tratada, com base em imagens tridimensionais provenientes de tomografia computadorizada (CT).");
            d.setText("É uma técnica que só pode ser usada com o tratamento com IT.");
            e.setText("É uma técnica que só pode ser utilizada com o tratamento com IGRT.");
            alt = R.id.c;
        }
        if (question == 144) {
            questaoTextView.setText("A Radioterapia com modulação da intensidade do feixe de radiação (IMRT) é uma técnica que está sendo muito utilizada em grandes serviços de radioterapia. Em relação a esse tema, assinale a alternativa que apresenta a vantagem dessa técnica.");
            a.setText("O sistema de planejamento vira um acessório secundário em sua implementação.");
            b.setText("Com a IMRT não se consegue modular a dose de radiação, o que beneficia o tratamento.");
            c.setText("A técnica é indicada apenas para tumores pélvicos.");
            d.setText("Não é necessário controle de qualidade.");
            e.setText("IMRT é uma evolução da técnica 3D conformacional que possibilita aumentar a conformação da dose ao alvo e poupar melhor os tecidos saudáveis, reduzindo os efeitos colaterais da radioterapia.");
            alt = R.id.e;
        }
        if (question == 145) {
            questaoTextView.setText("No que se refere às técnicas em radioterapia, assinale a alternativa correta.");
            a.setText("O bólus é um acessório colocado na abertura do colimador do equipamento de teleterapia e é utilizado para homogeneizar a distribuição de dose no paciente.");
            b.setText("Uma bomba de Cobalto emite ondas eletromagnéticas com energias de 1,17 MeV e de 1,33 MeV.");
            c.setText("Um técnico de radioterapia seleciona a MV de um acelerador linear antes de iniciar o procedimento de um tratamento teleterápico.");
            d.setText("Os blocos de colimação são acessórios inseridos em cavidades anatômicas, com o objetivo de proteger determinadas regiões anatômicas dos efeitos das radiações ionizantes.");
            e.setText("Um tubo de raios X que tenha o anodo retrátil pode produzir feixes radioterápicos de elétrons e de raios X.");
            alt = R.id.b;
        }
        if (question == 146) {
            questaoTextView.setText("Com relação à técnica de tratamento de braquiterapia na radioterapia, assinale a alternativa correta.");
            a.setText("Fonte radioisotópica próxima ou em contato com o paciente.");
            b.setText("Utilização de máscara facial termoplástica.");
            c.setText("Uso de radioisótopos que contaminam radioativamente o paciente.");
            d.setText("Quanto mais grave a doença, maior a necessidade do tratamento em HDR em detrimento ao tratamento em LDR.");
            e.setText("Irradiação com raios X de megavoltagem.");
            alt = R.id.a;
        }
        if (question == 147) {
            questaoTextView.setText("A Comissão Nacional de Energia Nuclear (CNEN) estabelece, na Norma CNEN-NN-3.01, os requisitos básicos de radioproteção dos indivíduos expostos à radiação ionizante. De acordo com esta norma, assinale a alternativa INCORRETA. ");
            a.setText("O limite de dose efetiva anual para o corpo inteiro de um indivíduo público é de 1 mSv. ");
            b.setText("Apenas os indivíduos com idade igual ou superior a 18 anos podem estar sujeitos a exposições ocupacionais. ");
            c.setText("O limite de dose equivalente anual para o cristalino de um indivíduo ocupacionalmente exposto é de 20 mSv. ");
            d.setText("O limite de dose efetiva anual para o corpo inteiro de um indivíduo ocupacionalmente exposto é de 15 mSv. ");
            e.setText("No caso de mulheres gestantes ocupacionalmente expostas, a partir da notificação da gravidez, o feto não poderá receber dose efetiva superior a 1 mSv durante o resto do período gestacional. ");
            alt = R.id.d;
        }
        if (question == 148) {
            questaoTextView.setText("Homem, 51 anos, foi encaminhado ao pronto-socorro após acidente de automóvel. O exame físico indicava possibilidade de traumatismo craniano. Para averiguar o tipo de lesão, o médico solicitou um exame de raios X, incidência lateral do crânio. Das alternativas a seguir, qual explica corretamente a conduta do Tecnólogo em Radiologia durante a execução deste exame? ");
            a.setText("Paciente em decúbito dorsal. Raio central direcionado perpendicularmente ao receptor de imagem e centralizado a 2 cm acima do meato acústico externo. ");
            b.setText("Paciente em ortostase. Raio central direcionado perpendicularmente ao receptor de imagem e centralizado a 5 cm acima do meato acústico externo. ");
            c.setText("Paciente em decúbito dorsal. Se houver lesão na coluna cervical, não manipular a cabeça do paciente. Raio central perpendicular ao receptor de imagem e centralizado a 5 cm acima do meato acústico externo. ");
            d.setText("Paciente em decúbito dorsal. Se houver lesão na coluna cervical, colocar apoio para elevar a cabeça. Raio central perpendicular ao receptor de imagem e centralizado a 5 cm acima do meato acústico externo. ");
            e.setText("Paciente em decúbito dorsal. Raio central angulado em 5º cefálico e direcionado 5 cm acima do meato acústico externo. ");
            alt = R.id.c;
        }
        if (question == 149) {
            questaoTextView.setText("As patologias congênitas são imperfeições ou alterações morfológicas ou químicas originadas do nascimento, como a duplicação do ureter e pelve renal e o rim ectópico. O exame contrastado que permite o diagnóstico dessas patologias é a urografia excretora. Em relação a este exame, assinale a alternativa correta. ");
            a.setText("Não é necessário que o paciente faça preparo intestinal, pois o objetivo do exame é visibilizar os rins, ureteres, bexiga e uretra. ");
            b.setText("Administra-se o agente de contraste iodado por via intravenosa. Posteriormente, é realizada a rotina básica de varredura nas seguintes etapas: nefrograma, imagens após 5, 15 e 20 minutos e imagem pós-micção. ");
            c.setText("É um exame não-funcional do sistema excretor que utiliza o agente de contraste iodado introduzido diretamente retrógrado, via cateter, no sistema pielocalicinal. ");
            d.setText("O exame apresenta algumas contraindicações, como anúria, insuficiência renal e rim em ferradura. ");
            e.setText("É um exame funcional do sistema excretor que utiliza como agente de contraste o bário por via intravenosa. ");
            alt = R.id.b;
        }
        if (question == 150) {
            questaoTextView.setText("Câmara escura é o local onde ocorre todo o processamento químico responsável por tornar visível a imagem latente. Para que todo o processo aconteça de forma correta, a Portaria SVS/MS nº453, de 1 de junho de 1998, estabelece que ");
            a.setText("os filmes devem ser armazenados distantes de fontes de radiação, na posição vertical e em condições de temperatura e umidade indicadas pelo fabricante. ");
            b.setText("o sistema de iluminação de segurança da câmara escura deve estar localizado a uma distância inferior a 1,2 m da bancada de manipulação de filmes e écrans. ");
            c.setText("a câmara escura deve apresentar janelas para manter o ambiente arejado e fresco devido aos vapores dos produtos químicos. ");
            d.setText("os filmes radiográficos devem ser armazenados distantes das fontes de radiação e em posição horizontal. ");
            e.setText("não é permitido que haja interruptor de luz no interior da câmara escura para evitar acionamento acidental. ");
            alt = R.id.a;
        }
        if (question == 151) {
            questaoTextView.setText("As terminologias do posicionamento radiográfico são importantes para padronizar a comunicação entre os profissionais das técnicas radiológicas. De acordo com as terminologias, assinale a alternativa correta. ");
            a.setText("O plano horizontal de Frankfurt é o plano da base do crânio que passa no nível das margens superior-orbitais e pelas margens inferiores do meato acústico externo. ");
            b.setText("O plano oclusal compreende a superfície de oclusão dos dentes superiores e inferiores quando estes estão fechados. ");
            c.setText("A posição supina é quando o paciente está em decúbito sobre a região ventral. ");
            d.setText("A posição prona é quando o paciente está em decúbito sobre a região dorsal. ");
            e.setText("A posição de Trendelenburg é quando o paciente está em decúbito, porém com o corpo inteiro inclinado, de forma que a cabeça esteja posicionada mais elevada que os pés. ");
            alt = R.id.b;
        }
        if (question == 152) {
            questaoTextView.setText("O plano que divide o corpo humano em região anterior e posterior, aproximadamente iguais, é denominado plano ");
            a.setText("médio-sagital. ");
            b.setText("médio-coronal. ");
            c.setText("coronal. ");
            d.setText("axial. ");
            e.setText("oblíquo. ");
            alt = R.id.b;
        }
        if (question == 153) {
            questaoTextView.setText("Em relação à anatomia do trato gastrointestinal, assinale a alternativa correta. ");
            a.setText("O esôfago é um canal muscular com, aproximadamente, 25 cm de extensão e 2 cm de diâmetro, que está localizado anterior à traqueia. ");
            b.setText("O intestino delgado é composto pelos cólons ascendente, transverso, descendente e sigmoide. ");
            c.setText("O estômago é subdividido em três partes principais, o fundo, o corpo e a porção pilórica. ");
            d.setText("O intestino grosso tem início na válvula pilórica do estômago e é dividido em três porções, o duodeno, o jejuno e o íleo. ");
            e.setText("O fígado, o pâncreas, o baço e o ceco são órgãos acessórios do trato gastrointestinal. ");
            alt = R.id.c;
        }
        if (question == 154) {
            questaoTextView.setText("Os exames de tomografia computadorizada do abdome e pelve têm a capacidade de mostrar as estruturas anatômicas devido a sua velocidade e precisão. De acordo com esse exame, assinale a alternativa correta ");
            a.setText("O protocolo de rotina da tomografia computadorizada de abdome inclui cortes de 7-10 mm de espessura e varredura do diafragma até a 11ª vértebra torácica. ");
            b.setText("O protocolo de rotina da tomografia da pelve inclui cortes de 7-10 mm de espessura e varredura da espinha ilíaca ântero-superior até a sínfise púbica. ");
            c.setText("No estudo do trato gastrointestinal, pode ser usado apenas o contraste iodado. ");
            d.setText("O meio de contraste administrado por via oral deve ser ingerido apenas em duas etapas, na noite que antecede o exame e imediatamente antes do exame. ");
            e.setText("O protocolo de rotina da tomografia computadorizada de abdome inclui cortes de 7-10 mm de espessura e varredura do diafragma até as cristas ilíacas. ");
            alt = R.id.e;
        }
        if (question == 155) {
            questaoTextView.setText("A medicina nuclear é uma especialidade médica que emprega radiofármacos para diagnosticar diversos tipos de patologias. A CNEN criou a norma CNEN NN – 3.05 com os requisitos de segurança e proteção radiológica para serviços de medicina nuclear. De acordo com essa norma, assinale a alternativa INCORRETA. ");
            a.setText("O indivíduo ocupacionalmente exposto deve utilizar, adequadamente, os monitores individuais de corpo inteiro e de extremidade fornecidos pelo Serviço de Medicina Nuclear. ");
            b.setText("O indivíduo ocupacionalmente exposto que manipula ou administra radiofármaco deve preparar e fracionar o radiofármaco de acordo com os protocolos estabelecidos pelo Serviço de Medicina Nuclear. ");
            c.setText("O indivíduo ocupacionalmente exposto deve verificar a existência de contaminação radioativa nos instrumentos de medição e nos equipamentos de diagnóstico. ");
            d.setText("O indivíduo ocupacionalmente exposto não pode realizar as atividades do programa de controle de qualidade em medicina nuclear, porque há outro profissional designado para essa função. ");
            e.setText("O indivíduo ocupacionalmente exposto deve submeter-se aos exames periódicos. ");
            alt = R.id.d;
        }
        if (question == 156) {
            questaoTextView.setText("Os detectores de radiação são dispositivos utilizados para identificar e, muitas vezes, mensurar a quantidade de radiação presente. Sobre os detectores de radiação utilizados na dosimetria, assinale a alternativa correta. ");
            a.setText("O dosímetro termoluminescente (TLD) é composto por um material cristalino dielétrico e pode ser reutilizado após a leitura. ");
            b.setText("O detector Geiger Müller tem a capacidade de discriminar energias e pode ser utilizado para estimar as grandezas como dose e exposição. ");
            c.setText("O dosímetro luminescente opticamente estimulado (OSL) é composto por óxido de alumínio e apresenta baixa sensibilidade. ");
            d.setText("Os filmes radiográficos também podem ser utilizados como detectores de radiação por meio da análise das densidades ópticas. A vantagem em utilizá-los é que eles não sofrem influência do calor e nem da umidade excessiva. ");
            e.setText("Não é necessário realizar a calibração do TLD antes do seu uso. ");
            alt = R.id.a;
        }
        if (question == 157) {
            questaoTextView.setText("A interação da radiação com os tecidos do corpo humano pode provocar efeitos biológicos. Em relação a esse tema, assinale a alternativa correta. ");
            a.setText("A morte celular pode ocorrer quando a dose da irradiação é elevada, na ordem de vários Gy, porém alguns tecidos apresentam maior sensibilidade à radiação, como o tecido ósseo. ");
            b.setText("Os efeitos físicos ocorrem quando os radicais livres, íons e os agentes oxidantes podem atingir moléculas importantes das células, como o cromossomo. ");
            c.setText("Os efeitos químicos ocorrem quando surgem muitos elétrons e íons livres no local de interação da radiação, devido à quebra das ligações químicas. ");
            d.setText("Os efeitos biológicos compreendem a fase em que pode ocorrer uma redução da quantidade de leucócitos, hemácias e plaquetas devido à exposição à radiação, porém não é possível o organismo retornar aos níveis de contagem anteriores destes elementos no sangue. ");
            e.setText("Os efeitos orgânicos surgem quando a quantidade ou a frequência dos efeitos biológicos, produzidos pela radiação, começam a desequilibrar o organismo e provocar doenças. ");
            alt = R.id.e;
        }
        if (question == 158) {
            questaoTextView.setText("De acordo com o Código de Ética dos Profissionais das Técnicas Radiológicas estabelecido pelo Conselho Nacional de Técnicos em Radiologia (CONTER), o tecnólogo, técnico e auxiliar em radiologia ");
            a.setText("podem fornecer ao cliente/paciente informações diagnósticas verbais ou escritas sobre os procedimentos realizados. ");
            b.setText("não podem denunciar ao Conselho Regional as irregularidades dentro do seu local de trabalho, que venham prejudicar a sua dignidade profissional. ");
            c.setText("devem dedicar-se ao aperfeiçoamento e atualização de seus conhecimentos técnicos científicos e a sua cultura geral, para a promoção do bem-estar social. ");
            d.setText("não podem recusar-se a executar atividades que não sejam de sua competência legal. ");
            e.setText("devem observar, rigorosamente, as normas de proteção radiológica no desempenho de suas atividades profissionais para resguardar apenas a sua saúde. ");
            alt = R.id.c;
        }
        if (question == 159) {
            questaoTextView.setText("De acordo com a anatomia do sistema esquelético e das articulações, assinale a alternativa correta. ");
            a.setText("Os ossos trapézio, trapezoide, cuboide e capitato são ossos do carpo. ");
            b.setText("Os ossos frontal, etmoide, esfenoide e maxila são classificados como ossos pneumáticos. ");
            c.setText("Os ossos cuneiformes medial, intermédio e lateral, navicular e piramidal são ossos do tarso. ");
            d.setText("O joelho é formado pela articulação entre o fêmur e a tíbia (articulação femurotibial), pelos epicôndilos medial e lateral do fêmur e pelo olécrano. ");
            e.setText("O osso esterno é formado pela incisura troclear, manúbrio, corpo e processo xifoide. ");
            alt = R.id.b;
        }
        if (question == 160) {
            questaoTextView.setText("Em um serviço de medicina nuclear, com grande fluxo de exames, há muitos frascos com radiofármacos que, na maioria das vezes, estão na forma líquida, o que pode resultar em derramamento acidental. Considerando as contaminações radioativas, assinale a alternativa INCORRETA. ");
            a.setText("Acidentes envolvendo menos de 1mCi I-131 são considerados de menor importância. ");
            b.setText("Em casos de contaminações menores, as pessoas da área são comunicadas. ");
            c.setText("A área de contaminação de menor importância deve ser continuamente monitorada com detector Geiger Müller. ");
            d.setText("Para os acidentes de maior importância, o ambiente deve ser rapidamente evacuado e não é necessária a presença do supervisor de radioproteção. ");
            e.setText("Tanto nas contaminações maiores quanto nas menores deve-se ter cuidado especial com a taxa de exposição dos pacientes, de toda a equipe e do meio ambiente, mantendo-a em um valor mínimo possível. ");
            alt = R.id.d;
        }
        if (question == 161) {
            questaoTextView.setText("A cintilografia óssea é um exame de alta sensibilidade para diagnosticar doenças de diversos tipos precocemente, sendo capaz de avaliar todo esqueleto a um baixo custo. Sobre este exame, assinale a alternativa correta. ");
            a.setText("Antes do exame, o paciente deve estar bem hidratado, deve retirar todos os objetos metálicos, não sendo necessário esvaziar a bexiga. ");
            b.setText("É contraindicado para pacientes com metástases ósseas. ");
            c.setText("O radiofármaco mais comumente utilizado para o estudo de corpo inteiro é o Tc-99m – difosfonato, com atividade de 20 mCi (740 MBq), administrado por via intravenosa. ");
            d.setText("A aquisição das imagens é realizada pelo equipamento de densitometria óssea. ");
            e.setText("Utiliza o meio de contraste iodado, via intravenosa, para diferenciar a lesão da estrutura óssea. ");
            alt = R.id.c;
        }
        if (question == 162) {
            questaoTextView.setText("Em relação aos princípios físicos da Ressonância Magnética, assinale a alternativa correta. ");
            a.setText("Utiliza ondas de radiofrequência, que são radiações ionizantes, para a formação das imagens. ");
            b.setText("O núcleo do oxigênio é abundante no corpo humano (80%), por isso é considerado o núcleo ativo utilizado nas imagens por ressonância clínica. ");
            c.setText("A frequência de precessão é encontrada por meio da equação de Larmor. ");
            d.setText("As leis do eletromagnetismo afirmam que um campo magnético é criado quando uma partícula carregada permanece em repouso. ");
            e.setText("O movimento de precessão ocorre quando o átomo de hidrogênio gira sobre o seu próprio eixo. ");
            alt = R.id.c;
        }
        if (question == 163) {
            questaoTextView.setText("É muito importante que o tecnólogo em radiologia selecione os parâmetros técnicos de exposição de modo a obter imagens radiográficas com qualidade diagnóstica. Quanto a estes parâmetros, assinale a alternativa correta. ");
            a.setText("A kVp é responsável primária pela densidade radiográfica. ");
            b.setText("A mA é responsável primária do contraste radiográfico. ");
            c.setText("A kVp fornece a qualidade do feixe de raios X. ");
            d.setText("A mA fornece a qualidade do feixe de raios X. ");
            e.setText("Valores altos de kVp originam imagens de alto contraste. ");
            alt = R.id.c;
        }
        if (question == 164) {
            questaoTextView.setText("Distorção é a alteração do tamanho ou do formato do objeto projetado sobre o filme radiográfico. A distorção pode ser controlada por quatro fatores principais, são eles: ");
            a.setText("distância fonte-receptor de imagem, distância objeto-receptor de imagem, alinhamento objeto-receptor de imagem e alinhamento do raio central. ");
            b.setText("distância fonte-receptor de imagem, distância objeto-receptor de imagem, tamanho do ponto focal e alinhamento do raio central. ");
            c.setText("distância fonte-receptor de imagem, tempo de exposição, alinhamento objeto-receptor de imagem e tamanho do ponto focal. ");
            d.setText("distância objeto-receptor de imagem, colimação, alinhamento objeto-receptor de imagem e alinhamento do raio central. ");
            e.setText("distância objeto-receptor de imagem, colimação, tamanho do ponto focal e tempo de exposição. ");
            alt = R.id.a;
        }
        if (question == 165) {
            questaoTextView.setText("Preencha as lacunas e assinale a alternativa correta. O exame de raios X dentário representa 33% de todos os exames médicos. A radiografia ____________ é uma técnica intraoral, cuja finalidade é detectar cáries nos dentes molares e pré-molares superiores e inferiores, avaliar restaurações existentes e a condição periodontal. O localizador é introduzido na boca, rodado sobre a língua e ajustado _______________. O paciente deve morder levemente o bloco de mordida. ");
            a.setText("interproximal (Bitewing) / no sulco lingual ");
            b.setText("periapical / entre os dentes ");
            c.setText("panorâmica / no sulco lingual ");
            d.setText("interproximal (Bitewing) / entre os dentes ");
            e.setText("oclusal / entre os dentes ");
            alt = R.id.a;
        }
        if (question == 166) {
            questaoTextView.setText("Em relação aos sistemas de imagens digitais, analise as assertivas e assinale a alternativa que aponta a(s) correta(s). \n\rI. A radiografia computadorizada é uma técnica de aquisição de imagens que substitui os chassis com écran por placas de imagem.\n\r II. A radiologia digital direta apresenta um sistema mais rápido de aquisição de imagens que a radiologia computadorizada, pois o equipamento de raios X apresenta um detector na mesa de exame e fornece a imagem em tempo real.\n\rIII. O PACS (Sistema de Armazenamento e Comunicação de Imagens) deve ser integrado com o RIS (Sistema de Informação Radiológica) do HIS (Sistema de Informação Hospitalar). A desvantagem em utilizar o PACS é que as imagens podem ser visualizadas somente no departamento de radiologia do hospital.  ");
            a.setText("Apenas I. ");
            b.setText("Apenas II. ");
            c.setText("Apenas I e II. ");
            d.setText("Apenas I e III. ");
            e.setText("I, II e III.");
            alt = R.id.c;
        }
        if (question == 167) {
            questaoTextView.setText("De acordo com o sistema tela-filme, assinale a alternativa correta. ");
            a.setText("O écran é composto por uma camada de fósforo. Esta camada deve apresentar eficiência de absorção, ou seja, deve produzir luz na mesma proporção da quantidade de radiação que interage com o fósforo. ");
            b.setText("A camada refletora do écran fica localizada entre a camada protetora e a camada de fósforo. ");
            c.setText("Os filmes radiográficos, tanto de mamografia quanto o de raios X convencional, são compostos por dupla camada de emulsão. ");
            d.setText("O écran é utilizado apenas para proteger o filme radiográfico contra a luz, pois não interfere na produção da imagem. ");
            e.setText("A camada de fósforo do écran tem a capacidade de converter a energia dos raios X em luz visível. Esta propriedade é denominada eficiência de conversão. ");
            alt = R.id.e;
        }
        if (question == 168) {
            questaoTextView.setText("A tomografia computadorizada é um método que fornece imagens axiais do corpo e, a partir destas imagens, faz a reconstrução a fim de obter imagens coronais e sagitais. Em relação a este exame, assinale a alternativa correta. ");
            a.setText("Utiliza o gadolínio como meio de contraste. ");
            b.setText("O equipamento é composto pelo gantry, mesa de exame, painel de comando e bobina gradiente. ");
            c.setText("O ponto de referência dos números de CT é o ar, cujo valor é zero. ");
            d.setText("Pitch é um índice que representa a relação entre a velocidade da mesa e a espessura do corte. ");
            e.setText("A água apresenta o valor +1000 do número CT. ");
            alt = R.id.d;
        }
        if (question == 169) {
            questaoTextView.setText("De acordo com a Norma CNEN-NN-3.01, assinale a alternativa correta. ");
            a.setText("O símbolo internacional das radiações ionizantes é representado pelas cores amarela e preta. ");
            b.setText("As áreas supervisionadas não necessitam ser indicadas como tal, em seus acessos, apenas as áreas controladas.  ");
            c.setText("A otimização é um dos princípios básicos de proteção radiológica que afirma que o uso das radiações deve apresentar benefício maior que o detrimento. ");
            d.setText("Área controlada é a área sujeita a regras especiais de proteção e segurança, com o objetivo de controlar as exposições normais, prevenir a disseminação de contaminação radioativa e prevenir ou limitar a amplitude das exposições potenciais. ");
            e.setText("Ação protetora é a ação tomada durante uma intervenção em campos de radiação existentes, com o objetivo de reduzir doses. ");
            alt = R.id.d;
        }
        if (question == 170) {
            questaoTextView.setText("Devido à presença do campo magnético na sala de exames de ressonância magnética, é essencial que os profissionais das técnicas radiológicas cuidem da segurança dos pacientes e acompanhantes. Dentre os itens a seguir, qual alternativa NÃO apresenta uma contraindicação ao exame? ");
            a.setText("Portadores de marcapasso. ");
            b.setText("Indivíduos claustrofóbicos. ");
            c.setText("Portadores de próteses metálicas. ");
            d.setText("Portadores de clipes de aneurisma. ");
            e.setText("Portadores de prótese mamária de silicone. ");
            alt = R.id.e;
        }
        if (question == 171) {
            questaoTextView.setText("Enema opaco é um exame contrastado utilizado para avaliar o intestino grosso. Sobre este exame, assinale a alternativa correta. ");
            a.setText("Utiliza como meio de contraste o bário, via oral. A primeira radiografia deve ser realizada 15 ou 30 minutos após a ingestão do contraste. ");
            b.setText("Utiliza como meio de contraste o bário, via retal. É contraindicado em casos de possível víscera oca perfurada e uma possível obstrução do intestino grosso. ");
            c.setText("Utiliza o meio de contraste iodado, via retal. É contraindicado em caso de apendicite. ");
            d.setText("Utiliza o meio de contraste duplo (bário e ar), via retal. É contraindicado em casos de neoplasias, pólipos e divertículos. ");
            e.setText("Utiliza como meio de contraste o bário, via oral. É contraindicado em caso de apendicite e neoplasias.");
            alt = R.id.b;
        }
        if (question == 172) {
            questaoTextView.setText("O efeito fotoelétrico ocorre quando a luz incide sobre uma fotocélula. Para que esse evento ocorra é necessário que ");
            a.setText("o quantum de energia de um fóton da luz incidente seja diretamente proporcional à sua intensidade. ");
            b.setText("a quantidade de elétrons emitidos por unidade de tempo dependa do quantum de energia da luz incidente. ");
            c.setText("os elétrons arrancados do metal saiam todos com a mesma energia cinética. ");
            d.setText("a quantidade de elétrons emitidos por unidade de tempo dependa da frequência da luz incidente. ");
            e.setText("haja uma energia mínima dos fótons da luz incidente para arrancar os elétrons do metal. ");
            alt = R.id.a;
        }
        if (question == 173) {
            questaoTextView.setText("Com relação aos tipos de radiação e às suas características, assinale a alternativa INCORRETA. ");
            a.setText("Os nêutrons têm capacidade de penetração através da matéria superior à das partículas beta. ");
            b.setText("As radiações gama interagem com a matéria pelo efeito fotoelétrico, efeito Compton ou pela produção de pares. ");
            c.setText("A desintegração dos radionuclídeos é um fenômeno nuclear. ");
            d.setText("As partículas alfa têm um grande poder de ionização e apresentam uma trajetória retilínea quando percorrem um trecho livre de cargas. ");
            e.setText("A desintegração dos radionuclídeos não é um fenômeno nuclear. ");
            alt = R.id.e;
        }
        if (question == 174) {
            questaoTextView.setText("Em relação à radiação X, assinale a alternativa correta. ");
            a.setText("A radiação X não sofre interferência, polarização, refração ou reflexão. ");
            b.setText("Em geral, a radiação X apresenta menor facilidade de penetração em tecidos moles que a luz visível. ");
            c.setText("A radiação X é composta de ondas longitudinais. ");
            d.setText("Na radiação X, há dois tipos de campos oscilantes envolvidos, que são os campos elétrico e magnético paralelos entre si. ");
            e.setText("Em geral, a radiação X apresenta maior facilidade de penetração em tecidos moles que a luz visível. ");
            alt = R.id.e;
        }
        if (question == 175) {
            questaoTextView.setText("Dentre as propriedades fundamentais dos Raios-X, assinale a alternativa INCORRETA. ");
            a.setText("Provocam luminescência em determinados sais metálicos. ");
            b.setText("Tornam-se “duros” (mais penetrantes) após passarem por materiais absorvedores. ");
            c.setText("Atravessam um corpo tanto melhor, quanto maior for a tensão (voltagem) do tubo (kV). ");
            d.setText("Propagam-se em linha reta em uma única direção. ");
            e.setText("No vácuo, propagam-se com a velocidade da luz. ");
            alt = R.id.d;
        }
        if (question == 176) {
            questaoTextView.setText("O Césio−137 tem meia-vida aproximada de 30 anos. Considerando uma amostra inicial de 1600 g, qual é a massa de Césio puro, em mg, que restará 120 anos depois? ");
            a.setText("0,8. ");
            b.setText("1,0. ");
            c.setText("0,1. ");
            d.setText("1,2. ");
            e.setText("0,2. ");
            alt = R.id.c;
        }
        if (question == 177) {
            questaoTextView.setText("De acordo com as diretrizes básicas da CNEN. Para indivíduos ocupacionalmente expostos e para indivíduos que moram na vizinhança de uma instalação de radioterapia, as doses individuais acumuladas em 50 anos não podem exceder, respectivamente, os seguintes valores: ");
            a.setText("2,5Sv e 250mSv. ");
            b.setText("1Sv e 50mSv. ");
            c.setText("50mSv e 1mSv. ");
            d.setText("20mSv e 5mSv. ");
            e.setText("50mSv e 1Sv. ");
            alt = R.id.b;
        }
        if (question == 178) {
            questaoTextView.setText("Uma fonte pontual, na qual se mede 36mR/h a uma distância de 0,5m, terá sua intensidade reduzida à metade a uma distância, em metros, de ");
            a.setText("0,90 ");
            b.setText("1,5. ");
            c.setText("0,70 ");
            d.setText("1,7. ");
            e.setText("1,2. ");
            alt = R.id.c;
        }
        if (question == 179) {
            questaoTextView.setText("A dose limite ocupacional anual e sua unidade de medida para órgãos e tecidos, exceto os cristalinos, são, respectivamente: ");
            a.setText("0,5mSv. ");
            b.setText("500 Sv. ");
            c.setText("500 mSv. ");
            d.setText("1,50 mSv. ");
            e.setText("50 mSv. ");
            alt = R.id.c;
        }
        if (question == 180) {
            questaoTextView.setText("Levando em consideração as atividades de radioproteção, pode-se definir grandezas radiológicas mais consistentes ou úteis nas práticas. Em monitoração de área e individual, as grandezas são chamadas de ");
            a.setText("práticas. ");
            b.setText("individuais. ");
            c.setText("operacionais. ");
            d.setText("ocupacionais. ");
            e.setText("físicas. ");
            alt = R.id.c;
        }
        if (question == 181) {
            questaoTextView.setText("Com relação à radioterapia, assinale a alternativa INCORRETA. ");
            a.setText("O número de aplicações necessárias pode variar de acordo com a extensão e a localização do tumor, dos resultados dos exames e do estado de saúde do paciente. ");
            b.setText("Para programar o tratamento, é utilizado um aparelho chamado simulador. Através de radiografias, o médico delimita a área a ser tratada, marcando a pele com uma tinta vermelha. ");
            c.setText("Para que a radiação atinja somente a região marcada, em alguns casos pode ser feito um molde de gesso ou de plástico, para que o paciente se mantenha na mesmo posição durante a aplicação. ");
            d.setText("O paciente ficará deitado sob o aparelho, que estará direcionado para o traçado sobre a pele. É possível que sejam usados protetores de chumbo entre o aparelho e algumas partes do corpo, para proteger os tecidos e órgãos sadios. ");
            e.setText("De acordo com a localização do tumor, a radioterapia é feita de duas formas: Teleterapia, na qual os aparelhos ficam em contato com o organismo do paciente, e Braquiterapia, na qual os aparelhos ficam afastados do paciente. ");
            alt = R.id.e;
        }
        if (question == 182) {
            questaoTextView.setText("Com relação aos equipamentos utilizados em teleterapia, assinale a alternativa correta. ");
            a.setText("Densitômetro, Aceleradores Lineares e Câmara Cintilográfica. ");
            b.setText("Aparelhos de raios-X, Aceleradores Lineares e Bomba de Cobalto 60. ");
            c.setText("Bomba de Cobalto 60, Aparelhos de Raios-X, Tomógrafos. ");
            d.setText("Tomógrafo simulador, Aparelhos de Raios-X e Câmara Cintilográfica. ");
            e.setText("Densitômetro, Tomógrafo e Aceleradores Lineares. ");
            alt = R.id.b;
        }
        if (question == 183) {
            questaoTextView.setText("Os efeitos biológicos das radiações variam em função dos diferentes tipos de radiações e das diferentes energias de radiações de mesma natureza, inclusive quando aplicadas na mesma dose. Em consequência, julgou-se conveniente utilizar um outro tipo de unidade, capaz de conjugar a energia absorvida e os efeitos biológicos produzidos pelos diferentes tipos de radiação, conhecida como ");
            a.setText("kerma de colisão. ");
            b.setText("dose equivalente efetiva. ");
            c.setText("transferência linear de energia. ");
            d.setText("eficácia biológica relativa (RBE). ");
            e.setText("stopping power. ");
            alt = R.id.d;
        }
        if (question == 184) {
            questaoTextView.setText("Para uma mesma dose absorvida, o efeito biológico poderá ser maior ou menor, dependendo do tipo de radiação. Levando em consideração esse fato em conta, foi introduzida uma grandeza especial para fins de radioproteção. Esse fator considera que quanto maior o número de ionizações produzidas por unidade de comprimento, maior é o dano. Trata-se do fator ");
            a.setText("biológico Q. ");
            b.setText("de ponderação Q. ");
            c.setText("de correção Q. ");
            d.setText("de qualidade Q. ");
            e.setText("de otimização Q. ");
            alt = R.id.d;
        }

        if (question == 185) {
            questaoTextView.setText("Em relação à Medicina Nuclear, assinale a alternativa correta. ");
            a.setText("A física aplicada à Medicina Nuclear está relacionada à emissão e detecção da radiação não-ionizante. ");
            b.setText("Os isótopos radioativos ou radioisótopos, devido à propriedade de emitirem radiações, são utilizados apenas em Medicina Nuclear. ");
            c.setText("Radioisótopos emitem radiações eletromagnéticas (raios gama) ou radiações corpusculares (partículas beta). ");
            d.setText("Em Medicina Nuclear, diferentes emissores de raios-x são utilizados. ");
            e.setText("Radioisótopos emitem radiações eletromagnéticas (beta) ou radiações corpusculares (gama). ");
            alt = R.id.c;
        }
        if (question == 186) {
            questaoTextView.setText("Sobre o equipamento de Medicina Nuclear é correto afirmar que ");
            a.setText("a câmara possui um sistema de colimação, um cristal de cintilação, um conjunto de fotomultiplicadoras (PMT) e um motor para rotação do detector. ");
            b.setText("entre os cintiladores e as PMT existe um acoplamento óptico com fibra óptica. ");
            c.setText("o equipamento utilizado para confeccionar a imagem é chamado câmara Anger ou gama câmara. ");
            d.setText("os primeiros modelos comerciais de equipamento PET (1975), foram desenvolvidos por Ondendorf. ");
            e.setText("a câmara possui um sistema de cintilação, um cristal de colimação, um conjunto de fotomultiplicadoras (PMT) e um motor para rotação do detector. ");
            alt = R.id.a;
        }
        if (question == 187) {
            questaoTextView.setText("Sobre os detectores de radiação nuclear, assinale a alternativa correta. ");
            a.setText("Utilizam-se cristais cintiladores em MN. ");
            b.setText("Em Medicina Nuclear, necessitam ter número atômico (Z) baixo para que ocorra o efeito fotoelétrico. ");
            c.setText("Devem possuir alto poder de freamento da radiação e baixa densidade que caracteriza a eficiência. ");
            d.setText("São constituídos por cristais espessos de 1 a 12 mm para “frear” os fótons (diâmetros de 400 a 500 mm). ");
            e.setText("Devem possuir baixo poder de freamento da radiação e elevada densidade que caracteriza a eficiência. ");
            alt = R.id.a;
        }
        if (question == 188) {
            questaoTextView.setText("Sobre a função do colimador, assinale a alternativa INCORRETA. ");
            a.setText("Sua função ideal é deixar passar somente a radiação proveniente de um ponto do órgão mapeado. ");
            b.setText("Se o detector for colocado sem o colimador acima do órgão, o sistema ganha resolução e assim é capaz de mapear o órgão, pois toda a radiação de um amplo ângulo sólido seria capaz de atingir o detector. ");
            c.setText("Se não existisse o colimador, a exemplo, radiação do fígado, dos rins, do pâncreas, do baço e das vísceras atingiriam o detector com a mesma eficiência angular e assim a imagem praticamente não discriminaria a sua origem. ");
            d.setText("São feitos de chumbo e tem como função garantir que a radiação incida perpendicularmente no cristal cintilador. ");
            e.setText("Se o detector for colocado acima do órgão, o sistema ganha resolução e assim é capaz de mapear o órgão, pois toda a radiação de um amplo ângulo sólido seria capaz de atingir o detector. ");
            alt = R.id.b;
        }
        if (question == 189) {
            questaoTextView.setText("As Telas Intensificadoras, também conhecidas como écrans reforçadores, são placas de papelão especial ou plásticos revestidos por um material que, sob o impacto dos raios-x tornam-se ");
            a.setText("Refletivo. ");
            b.setText("Fosforescente. ");
            c.setText("Fluorescente. ");
            d.setText("Cintilante. ");
            e.setText("Bioluminescente. ");
            alt = R.id.c;
        }
        if (question == 190) {
            questaoTextView.setText("As etapas básicas do processo de revelação manual de um filme radiográfico é de ");
            a.setText("Revelação; Fixação; Lavagem e Secagem. ");
            b.setText("Revelação; Banho; Fixação; Lavagem e Secagem. ");
            c.setText("Revelação; Fixação e Secagem. ");
            d.setText("Banho; Revelação; Fixação e Secagem. ");
            e.setText("Banho; Revelação; Fixação; Lavagem e Secagem. ");
            alt = R.id.b;
        }
        if (question == 191) {
            questaoTextView.setText("Quando utilizamos um corte sagital, dividimos o corpo em ");
            a.setText("região superior e inferior. ");
            b.setText("região superior e esquerda. ");
            c.setText("região proximal e distal. ");
            d.setText("região direita e esquerda. ");
            e.setText("região anterior e posterior. ");
            alt = R.id.d;
        }
        if (question == 192) {
            questaoTextView.setText("Para a incidência Axial PA (Método de Haas), a LOM deve estar perpendicular ao filme, e a angulação do raio central em relação a LOM deve ser de ");
            a.setText("10º. ");
            b.setText("15º. ");
            c.setText("20º. ");
            d.setText("25º.");
            e.setText("32º. ");
            alt = R.id.d;
        }
        if (question == 193) {
            questaoTextView.setText("Para o estudo radiológico da Sela Túrcica demonstrando os clinoides posteriores utiliza-se a incidência AXIAL AP (Método de Towne). Para isso a angulação do raio central deve ser ");
            a.setText("30º caudal. ");
            b.setText("30º cefálico. ");
            c.setText("32º caudal. ");
            d.setText("32º cefálico. ");
            e.setText("37º caudal. ");
            alt = R.id.e;
        }
        if (question == 194) {
            questaoTextView.setText("A anatomia esquelética do adulto é formada por 206 ossos distintos, que compõem a estrutura de todo o organismo, em que o mesmo é dividido em esqueleto axial e esqueleto apendicular. Portanto faz parte do esqueleto apendicular ");
            a.setText("o crânio. ");
            b.setText("o esterno.");
            c.setText("a cintura pélvica. ");
            d.setText("a coluna cervical. ");
            e.setText("as costelas flutuantes. ");
            alt = R.id.c;
        }
        if (question == 195) {
            questaoTextView.setText("Faz parte dos ossos curtos ");
            a.setText("a escápula. ");
            b.setText("os ossos vertebrais. ");
            c.setText("os ossos faciais. ");
            d.setText("os ossos carpais. ");
            e.setText("os ossos da pelve. ");
            alt = R.id.d;
        }
        if (question == 196) {
            questaoTextView.setText("A anatomia humana apresenta pacientes de vários biótipos. Para uma radiografia de Tórax, um paciente que apresenta um tórax muito amplo e muito profundo, porém raso, é um paciente ");
            a.setText("astênico. ");
            b.setText("estênico. ");
            c.setText("hipoestênico. ");
            d.setText("hiperestênico. ");
            e.setText("hiperastênico. ");
            alt = R.id.d;
        }
        if (question == 197) {
            questaoTextView.setText("No suporte do foco anódico do tubo de RX utiliza-se");
            a.setText("tungstênio.");
            b.setText("alumínio.");
            c.setText("chumbo.");
            d.setText("níquel.");
            e.setText("cobre.");
            alt = R.id.e;
        }
        if (question == 198) {
            questaoTextView.setText("Entende-se por capa focalizadora ");
            a.setText("a calota de chumbo ao redor do tubo de RX.");
            b.setText("o filtro de alumínio colocado na janela do tubo de RX. o filtro de alumínio colocado na janela do tubo de RX.");
            c.setText("o invólucro ao redor do filamento catódico.");
            d.setText("o invólucro de vidro que protege o tubo de RX.");
            e.setText("o colimador do feixe de RX, diminuindo o campo de exposição.");
            alt = R.id.c;
        }
        if (question == 199) {
            questaoTextView.setText("Os focos do aparelho de RX (fino e grosso) são medidos em");
            a.setText("mm.");
            b.setText("cm.");
            c.setText("graus");
            d.setText("mA.");
            e.setText("volt.");
            alt = R.id.a;
        }
        if (question == 200) {
            questaoTextView.setText("As considerações abaixo dizem respeito às técnicas radiográficas.\nI. No RX de abdome, para a visualização dos diversos tons de cinza,devemos utilizar alto mAs.\nII. Nos exames realizados sem grade devemos retirar cerca de 10 KV da técnica inicial.\nIII. Nos exames urológicos, que necessitam de alto contraste das imagens, utilizamos técnicas de alto KV e baixo mAs.\nIV. Quando o tempo de exposição é muito curto aparecem na radiografia listras causadas pela grade.\nSomente está correto");
            a.setText("I e II.");
            b.setText("I e III.");
            c.setText("II e III.");
            d.setText("II e IV.");
            e.setText("III e IV.");
            alt = R.id.d;
        }
        if (question == 201) {
            questaoTextView.setText("No estudo do ombro, a melhor incidência para visualização do rebordo ântero-inferior da cavidade glenóide é:");
            a.setText("Ombro AP, com rotação interna.");
            b.setText("Perfil da escápula.");
            c.setText("Lawrence.");
            d.setText("West Point.");
            e.setText("Zanca.");
            alt = R.id.d;
        }
        if (question == 202) {
            questaoTextView.setText("Assinale a alternativa incorreta. ");
            a.setText("RX de abdome em decúbito lateral, com raios horizontais, pode ser empregado para substituir incidência ortostática em pacientes debilitados.");
            b.setText("A avaliação da idade óssea pelo método Greulich- Pyle é baseada na análise dos ossos do carpo e dispensa o estudo dos ossos das mãos.");
            c.setText("As incidências oblíquas da coluna cervical constituem recurso valioso para estudo de C7 quando esta não é bem demonstrada em AP ou perfil.");
            d.setText("A incidência lordótica é útil para a visualização dos ápices pulmonares e do lobo médio.");
            e.setText("Na suspeita de pequenos pneumotórax a incidência mais indicada é o RX de tórax PA com expiração forçada.");
            alt = R.id.b;
        }
        if (question == 203) {
            questaoTextView.setText("Incidência que projeta o dorso da sela túrcica no forame occipital é:");
            a.setText("Mento-naso.");
            b.setText("Fronto-naso.");
            c.setText("Schuller.");
            d.setText("Towne.");
            e.setText("Hirtz.");
            alt = R.id.d;
        }
        if (question == 204) {
            questaoTextView.setText("O trânsito intestinal em duplo contraste utiliza");
            a.setText("bário e ar.");
            b.setText("contraste iodado e ar.");
            c.setText("bário e metilcelulose.");
            d.setText("contraste iodado e metilcelulose.");
            e.setText("bário diluído.");
            alt = R.id.c;
        }
        if (question == 205) {
            questaoTextView.setText(" As frases abaixo estão relacionadas aos filmes de RX e telas intensificadoras.\nI. Os filmes de RX são fotossensíveis.\nII. Os écrans utilizados com filmes azuis são compostos de tungstato de cálcio.\nIII. A combinação entre filme verde e écran de terras raras diminui a vida média do tubo de RX.\nIV. O uso de filme verde e écran de terras raras tornou-se obrigatório a partir do ano de 2004 (portaria 453 da Vigilância Sanitária).\nSomente está correto ");
            a.setText("I e II.");
            b.setText("I e III.");
            c.setText("II e III.");
            d.setText("II e IV.");
            e.setText("III e IV.");
            alt = R.id.a;
        }
        if (question == 206) {
            questaoTextView.setText("Dentre as medidas de proteção radiológica, assinale a alternativa incorreta.: ");
            a.setText("O cabo disparador deve ter comprimento mínimo de 2m nos equipamentos de RX portáteis.");
            b.setText("O dosímetro individual deve ser colocado por cima do avental de chumbo.");
            c.setText("Uso de cortina ou saiote plumbífero para proteção do operador contra a radiação espalhada pelo paciente.");
            d.setText("Uso de grade antidifusora, que reduz a dose de radiação no paciente.");
            e.setText("Colimação do tamanho do campo.");
            alt = R.id.d;
        }
        if (question == 207) {
            questaoTextView.setText("Nas áreas “controladas” de um serviço de radiologia a dose ambiente máxima permitida é: ");
            a.setText("0,5mSv/ano.");
            b.setText("1,0mSv/ano.");
            c.setText("2,0mSv/ano.");
            d.setText("5,0mSv/ano.");
            e.setText("10,0mSv/ano.");
            alt = R.id.e;
        }
        if (question == 208) {
            questaoTextView.setText("A dose máxima anual permitida ao trabalhador exposto aos RX é de");
            a.setText("0,5mSv/ano.");
            b.setText("5,0mSv/ano.");
            c.setText("10,0mSv/ano.");
            d.setText("20,0mSv/ano.");
            e.setText("50,0mSv/ano.");
            alt = R.id.b;
        }
        if (question == 209) {
            questaoTextView.setText("A metilcelulose é um composto utilizado no");
            a.setText("trânsito intestinal em duplo contraste.");
            b.setText("colecistograma oral.");
            c.setText("colangiografia pelo dreno de Kehr.");
            d.setText("enema opaco em crianças pequenas.");
            e.setText("enema opaco do adulto, para pesquisa de megacólon.");
            alt = R.id.a;
        }
        if (question == 210) {
            questaoTextView.setText("As técnicas de radioterapia se dividem basicamente em clássicas e modernas,  mas ambas continuam sendo utilizadas.  Assinale a alternativa que apresenta, corretamente, a descrição dessas técnicas.");
            a.setText("Na radioterapia clássica, os campos são delimitados pelos colimadores “sólidos” – campos retangulares modificados por blocos não conformatórios.");
            b.setText("Na radioterapia clássica, a intensidade do feixe é inconstante (ou variável) nos planos transversos e paralelos.");
            c.setText("Na radioterapia moderna, a margem é grande na região do tumor, mas com dose de aplicação baixa.");
            d.setText("Na radioterapia moderna, a fusão de imagens de várias modalidades não é possível.");
            e.setText("Na radioterapia moderna, o paciente é representado pelo contorno externo.");
            alt = R.id.a;
        }
        if (question == 211) {
            questaoTextView.setText("Em relação aos contrastes utilizados em exames diagnósticos e suas reações adversas, assinale a alternativa correta.");
            a.setText("A dose efetiva média anual não deve exceder 20 mSv em qualquer período de 5 anos consecutivos, não podendo exceder 50 mSv em nenhum ano.");
            b.setText("A dose equivalente anual não deve exceder 800 mSv para extremidades e 350 mSv para o cristalino.");
            c.setText("Para técnicas radiológicas em grávidas, a dose na superfície do abdômen não deve exceder 20 mSv durante todo o período restante da gravidez.");
            d.setText("Para estudantes com idade entre 16 e 18 anos, em estágio de treinamento profissional, as exposições não devem exceder a dose efetiva anual de 10 mSv.");
            e.setText("Menores de 21 anos de idade não podem trabalhar com Raios X diagnósticos, exceto em treinamentos.");
            alt = R.id.a;
        }
        if (question == 212) {
            questaoTextView.setText("O posicionamento e a imobilização do paciente são muito importantes para o sucesso da radioterapia. Quanto aos imobilizadores, considere as afirmativas a seguir.\nI. São produzidos em material metálico rígido e não proporcionam adaptações a cada paciente.\nII. São utilizados no planejamento e tratamento diário.\nIII. Proporcionam maior conforto e possibilidade de reprodução do posicionamento.\nIV. Possibilitam a marcação da região a ser tratada.\nAssinale a alternativa correta.");
            a.setText("Somente as afirmativas I e II são corretas.");
            b.setText("Somente as afirmativas I e IV são corretas.");
            c.setText("Somente as afirmativas III e IV são corretas.");
            d.setText("Somente as afirmativas I, II e III são corretas.");
            e.setText("Somente as afirmativas II, III e IV são corretas.");
            alt = R.id.e;
        }
        if (question == 213) {
            questaoTextView.setText("A justificação é o princípio básico de proteção radiológica que estabelece que nenhuma prática, ou fonte adscrita a uma prática, deve ser autorizada a menos que produza suficiente benefício para o indivíduo exposto ou para a sociedade, de modo a compensar o detrimento que possa ser causado. O princípio da justificação em medicina e odontologia deve ser aplicado considerando");
            a.setText("a eficácia, os benefícios e os riscos de técnicas alternativas disponíveis que são justificados independentemente da dose.");
            b.setText("a exposição de seres humanos aos Raios X diagnósticos, com o objetivo de demonstração que se justificam apenas na formação profissional.");
            c.setText("os exames de rotina de tórax para fins de internação hospitalar, independentemente da motivação por que foram realizados.");
            d.setText("que a exposição médica e odontológica deve resultar em um benefício real para a saúde do indivíduo e/ou para a sociedade.");
            e.setText("que a justificação individual deve ser utilizada como objetivo nos projetos de blindagem ou para avaliação de conformidade em levantamentos radiométricos.");
            alt = R.id.d;
        }
        if (question == 215) {
            questaoTextView.setText("Para a obtenção de uma boa radiografia, é importante a observação de alguns fatores que interferem na formação da imagem e garantem sua nitidez e fidelidade.Sobre esses fatores, assinale a alternativa correta. ");
            a.setText("A distância da fonte de radiação/filme deve ser observada na proporção direta do quadrado da distância.");
            b.setText("O número atômico e a densidade do objeto a ser radiografado interferem no resultado radiográfico e são compensados pela miliamperagem");
            c.setText("O objeto e o receptor devem estar o mais próximo possível, e a fonte de Raios X, o mais distante possível.");
            d.setText("O objeto e o receptor devem estar posicionados com um ângulo de até 10◦ para a compensação pela técnica periapical da bissetriz.");
            e.setText("O tamanho dos cristais de prata do filme convencional interferem na quilovoltagem da tomada radiográfica a ser realizada, bem como a espessura da base.");
            alt = R.id.c;
        }
        if (question == 216) {
            questaoTextView.setText("As exposições ocupacionais normais de cada indivíduo, decorrentes de todas as práticas, devem ser controladas de modo que os valores dos limites estabelecidos na Resolução CNEN nº 12/1988 não sejam excedidos. Segundo essa resolução, assinale a alternativa que apresenta, corretamente, como o controle deve ser realizado. ");
            a.setText("A dose efetiva média anual não deve exceder 20 mSv em qualquer período de 5 anos consecutivos, não podendo exceder 50 mSv em nenhum ano.");
            b.setText("A dose equivalente anual não deve exceder 800 mSv para extremidades e 350 mSv para o cristalino");
            c.setText("Para técnicas radiológicas em grávidas, a dose na superfície do abdômen não deve exceder 20 mSv durante todo o período restante da gravidez.");
            d.setText("Para estudantes com idade entre 16 e 18 anos, em estágio de treinamento profissional, as exposições não devem exceder a dose efetiva anual de 10 mSv.");
            e.setText("Menores de 21 anos de idade não podem trabalhar com Raios X diagnósticos, exceto em treinamentos.");
            alt = R.id.a;
        }
        if (question == 217) {
            questaoTextView.setText("Na técnica intrabucal periapical da bissetriz, não são utilizados posicionadores de filme, portanto a observação dos pressupostos técnicos é imprescindível. Sobre esse tema, assinale a alternativa correta.");
            a.setText("A posição da cabeça para tomadas radiográficas de maxila é: plano sagital mediano perpendicular ao plano horizontal e plano trágus-asa do nariz paralelo ao plano horizontal.");
            b.setText("A fixação do filme para tomadas radiográficas de mandíbula deve ser com o dedo polegar da mão do lado oposto, com os dedos abertos em posição de continência.");
            c.setText("O posicionamento do filme para dentes posteriores é com seu longo eixo paralelo ao longo eixo do dente, com excesso oclusal de 1 a 2 cm.");
            d.setText("Os ângulos horizontais para tomadas radiográficas de maxila devem ser de −30º, −35º, −45º, −50º para molares, pré-molares, caninos e incisivos, respectivamente.");
            e.setText("Os ângulos verticais para tomadas radiográficas da mandíbula devem ser de +5º, +10º, +15º e +20º para molares, pré-molares, caninos e incisivos, respectivamente.");
            alt = R.id.a;
        }
        if (question == 218) {
            questaoTextView.setText("Nas radiografias de tórax para investigação de derrames pleurais, a técnica indicada é a posição de decúbito lateral anteroposterior. Em relação a essa técnica, assinale a alternativa correta.");
            a.setText("Deve haver uma maior aproximação, ou seja, menor distância entre a coluna vertebral e as bordas laterais das costelas do lado investigado.");
            b.setText("Exposição do feixe de Raios X realizada após a segunda expiração total, principalmente na suspeita de pneumotórax.");
            c.setText("O centro do campo de colimação deve ser a altura de T7 em pacientes de tamanho médio, e os braços não devem superpor-se à porção superior dos pulmões.");
            d.setText("Para que não ocorra superposição da imagem dos braços sobre os pulmões, levantar apenas o braço que está por cima do lado apoiado na maca.");
            e.setText("Pode ser realizada em decúbito lateral direito ou esquerdo, mas sempre com o lado suspeito para cima em relação à maca.");
            alt = R.id.c;
        }
        if (question == 219) {
            questaoTextView.setText("Na incidência posteroanterior para dedos, existem alguns critérios que demonstram a qualidade do exame radiográfico. Assinale a alternativa que apresenta, corretamente, um dos critérios para essa técnica: ");
            a.setText("As articulações interfalangianas devem apresentar-se fechadas, indicando completa supinação da mão.");
            b.setText("A ausência de rotação é demonstrada pela simetria dos lados ou concavidades das diáfises das falanges e metacarpianos distais.");
            c.setText("Exposição e contraste ótimos serão demonstrados pelo espaço da articulação interfalangiana proximal.");
            d.setText("O eixo longitudinal do dedo em observação deve estar posicionado na diagonal maior do chassi, principalmente em casos de fratura.");
            e.setText("O centro do campo de colimação deve ser na articulação intermetacarpiana medial do elemento afetado.");
            alt = R.id.b;
        }
        if (question == 220) {
            questaoTextView.setText("A técnica intrabucal oclusal para a região da sínfise mentoniana é indicada para investigação de fraturas ou grande lesões. Assinale a alternativa que apresenta,  corretamente, o ângulo para incidência do feixe de Raios X, desde que o plano oclusal esteja a 45º acima do plano horizontal.: ");
            a.setText("−30º");
            b.setText("−10º");
            c.setText("0º");
            d.setText("+15º");
            e.setText("+20º");
            alt = R.id.b;
        }
        if (question == 221) {
            questaoTextView.setText("Na avaliação da coluna cervical, têm-se variadas incidências. Uma das mais solicitadas é a técnica lateral. Sobre esse tema, assinale a alternativa correta.");
            a.setText("Corpos vertebrais cervicais, espaços articulares intervertebrais, processos espinhosos e articulações zigapofizárias são claramente demonstrados.");
            b.setText("Na impossibilidade de visualização de C7, devem-se alterar o centro do campo de colimação e a posição da mandíbula. Na impossibilidade de visualização de C7, devem-se alterar o centro do campo de colimação e a posição da mandíbula.");
            c.setText("O paciente deve ser posicionado em decúbito ventral sobre a maca ou a mesa com ampliação da extensão para visualização das estruturas.");
            d.setText("Solicitar ao paciente inspiração máxima e interromper nessa posição para a tomada radiográfica");
            e.setText("Solicitar ao paciente que mantenha a coluna ereta e leve os ombros o mais para trás possível desenrolando a articulação. Solicitar ao paciente que mantenha a coluna ereta e leve os ombros o mais para trás possível desenrolando a articulação.");
            alt = R.id.a;
        }
        if (question == 222) {
            questaoTextView.setText("Para a avaliação de ombro traumatizado, uma das técnicas preconizadas é a Incidência Lateral Y Escapular – oblíqua posteroanterior. Sobre essa técnica, assinale a alternativa correta. ");
            a.setText("A cabeça do úmero deve apresentar-se superposta à base do Y se o úmero estiver luxado e girado. A cabeça do úmero deve apresentar-se superposta à base do Y se o úmero estiver luxado e girado.");
            b.setText("A exposição ótima deve apresentar boa visualização do contorno da escápula com sobreposição das bordas das costelas sem muita nitidez.");
            c.setText("É indicada para excluir a luxação ou fraturas da porção medial do úmero e instabilidade escapuloumeral.");
            d.setText("O acrômio e os processos caracoides devem apresentar-se como hastes inferiores assimétricas do Y.");
            e.setText("O corpo delgado da escápula deve ser observado de ponta, não superposto pelas costelas.");
            alt = R.id.e;
        }
        if (question == 223) {
            questaoTextView.setText("Que matéria, indicada em uma das alternativas abaixo, ao interagir com radiações, apresenta o menor coeficiente de atenuação linear (50KeV)? ");
            a.setText("gelo");
            b.setText("ar");
            c.setText("agua");
            d.setText("tecido leve");
            e.setText("ossos");
            alt = R.id.b;
        }
        if (question == 224) {
            questaoTextView.setText("A quantidade de radiação ionizante, absorvida por um indivíduo numa exposição, depende\nI. do tipo de tecido irradiado.\nII. do tipo de radiação.\nIII. da energia da radiação incidente.\nÉ CORRETO o que está contido em  ");
            a.setText("I e II");
            b.setText("II e III");
            c.setText("I e III");
            d.setText("III");
            e.setText("I, II e III");
            alt = R.id.e;
        }
        if (question == 225) {
            questaoTextView.setText("A densidade eletrônica dos detectores de radiação tipo TLD é muito próxima à densidade eletrônica ");
            a.setText("2,5mm de Al para raio X. ");
            b.setText("2,0mm de Al para raio X. ");
            c.setText("1,5mm de Al para raio X. ");
            d.setText("1,0mm de Al para raio X. ");
            e.setText("0,5mm de Al para raio X. ");
            alt = R.id.a;
        }
        if (question == 226) {
            questaoTextView.setText("Analise os itens abaixo:\nI. Compressão apropriada da mama\nII. Ausência de dobras na pele\nIII. Simetria das imagens\nÉ CORRETO afirmar que a qualidade da imagem de uma mamografia é garantida pelo que está contido em ");
            a.setText("I");
            b.setText("I e III");
            c.setText("II e III");
            d.setText("III");
            e.setText("I, II e III");
            alt = R.id.e;
        }
        if (question == 227) {
            questaoTextView.setText("Analise os itens abaixo:\nI. A suspensão de anticoagulantes orais (se forem de uso contínuo)\nII. Jejum de seis horas\nIII. Exames de interesse ao caso clínico\nA alternativa que reúne o(s) procedimento(s) necessário(s) à efetivação de uma arteriografia é  ");
            a.setText("I");
            b.setText("I e II");
            c.setText("III");
            d.setText("II e III");
            e.setText("I,II e III");
            alt = R.id.e;
        }
        if (question == 228) {
            questaoTextView.setText("A utilização do perfil esquerdo como incidência de rotina no estudo radiográfico do tórax tem por objetivo");
            a.setText("dar maior nitidez aos ápices");
            b.setText("gerar imagens artefatuais");
            c.setText("aproximar o coração do filme");
            d.setText("avaliar os arcos costais");
            e.setText("demonstrar as claviculas");
            alt = R.id.c;
        }
        if (question == 229) {
            questaoTextView.setText("Em que posição deve estar, preferencialmente, uma paciente, ao realizar mamografia de rotina nas incidências craniocaudal e médio lateral oblíqua? ");
            a.setText("Ortostática ");
            b.setText("Decúbito lateral esquerdo ");
            c.setText("Decúbito ventral ");
            d.setText("Inclinada tangencialmente ");
            e.setText("De costas para o mamógrafo ");
            alt = R.id.a;
        }
        if (question == 230) {
            questaoTextView.setText("O monitoramento individual de dose de corpo inteiro do pessoal ocupacionalmente exposto à radiação ionizante geralmente é feito por meio de ");
            a.setText("contador geizer. ");
            b.setText("dosímetro na forma de crachá ");
            c.setText("avental plumbífero ");
            d.setText("colimador luminoso ");
            e.setText("protetor de tireoide ");
            alt = R.id.b;
        }
        if (question == 231) {
            questaoTextView.setText("Incidência anteroposterior com rotação externa do membro superior é utilizada para o estudo radiográfico de ");
            a.setText("mão");
            b.setText("bacia");
            c.setText("ombro");
            d.setText("couna ");
            e.setText("esterno");
            alt = R.id.c;
        }
        if (question == 232) {
            questaoTextView.setText("É de responsabilidade do técnico em radiologia, de conformidade com a Portaria Nº 453/1998, da Agência Nacional de Vigilância Sanitária (ANVISA)");
            a.setText("elaborar e manter atualizado o memorial descritivo de proteção radiológica. ");
            b.setText("revisar e atualizar periodicamente os procedimentos operacionais, de modo a garantir a otimização da proteção radiológica ");
            c.setText("coordenar o programa de treinamento periódico da equipe sobre os aspectos de proteção radiológica e garantia de qualidade. ");
            d.setText("realizar monitoração de área periodicamente e manter os assentamentos dos dados obtidos, incluindo informações sobre ações corretivas ");
            e.setText("manter assentamento, em livro próprio, de qualquer ocorrência relevante sobre condições de operação e de segurança de equipamentos, das manutenções e dos reparos. ");
            alt = R.id.e;
        }
        if (question == 233) {
            questaoTextView.setText("A Portaria nº 453/1998, do Ministério da Saúde estabelece as diretrizes básicas de proteção radiológica em relação a(à): ");
            a.setText("radiodiagnóstico, mamografia e tomografia computadorizada.");
            b.setText("ultrassonografia e ressonância magnética ");
            c.setText("cintilografia e dopplerfluxometria ");
            d.setText("manometria e endoscopia ");
            e.setText("videolaparoscopia e ecocardiografia ");
            alt = R.id.a;
        }
        if (question == 234) {
            questaoTextView.setText("O filme dosimétrico, as canetas dosimétricas e os dosímetros termoluminescentes indicam: ");
            a.setText("dose instantânea ");
            b.setText("dose crítica. ");
            c.setText("dose admissível.. ");
            d.setText("taxa de dose. ");
            e.setText("dose acumulada. ");
            alt = R.id.e;
        }
        if (question == 235) {
            questaoTextView.setText("Com base nos seus conhecimentos sobre Ressonância Magnética (RMN) e Tomografia Computadorizada (TC), analise as afirmativas abaixo:\nI. No exame de tomografia computadorizada, o lado direito do paciente na imagem corresponde ao lado direito da tela em relação ao observador.\nII. A tomografia computadorizada com técnica helicoidal permite adquirir um conjunto de dados brutos que podem ser trabalhados para gerar imagens com diferentes espessuras de corte.\nIII. Algumas das principais contraindicações à realização de tomografia computadorizada incluem uso de marcapasso. \nÉ CORRETO o que se afirma em ");
            a.setText("I");
            b.setText("II");
            c.setText("III");
            d.setText("I e II");
            e.setText("I, II  e III");
            alt = R.id.b;
        }
        if (question == 236) {
            questaoTextView.setText("Considerando os seus conhecimentos relacionados aos filmes radiográficos e écrans, assinale a alternativa CORRETA ");
            a.setText("Os filmes radiográficos não podem ser usados em exames de mamografia. ");
            b.setText("No filme radiográfico, não existe diferença de densidade óptica, ou seja, contraste radiográfico ");
            c.setText("O écran tem como principal função emitir luz quando exposto aos raios X e diminuir a dose de radiação no paciente ");
            d.setText("Os filmes radiográficos possuem, apenas, uma camada de emulsão. ");
            e.setText("A câmara escura não necessita de luz de segurança. ");
            alt = R.id.a;
        }
        if (question == 237) {
            questaoTextView.setText("A respeito das várias fases do processamento radiográfico e dos vários componentes químicos que fazem parte do revelador, assinale a alternativa CORRETA. ");
            a.setText("As condições climáticas da câmara escura não afetam o processamento ");
            b.setText("As sequências das fases do processamento são: fixador, revelador e secagem. ");
            c.setText("O sulfito de sódio não está presente nem no revelador nem no fixador. ");
            d.setText("O alúmen de cromo é responsável por impedir o amolecimento da gelatina; é um tipo de agente endurecedor. ");
            e.setText("O processamento automático é composto por duas etapas: revelação e fixação. ");
            alt = R.id.b;
        }
        if (question == 238) {
            questaoTextView.setText("O nome do Músculo visualizado em Raio-x de abdômen simples se encontra na alternativa ");
            a.setText("quadrado lombar");
            b.setText("trapézio");
            c.setText("psoas");
            d.setText("iliaco");
            e.setText("retoabdominal");
            alt = R.id.c;
        }
        if (question == 239) {
            questaoTextView.setText("Incidências usadas para verificar fratura de punho em um paciente se encontram listadas na alternativa ");
            a.setText("AP e axial com angulação de 20 graus ");
            b.setText("PA e oblíqua ");
            c.setText("Perfil e axial com angulação de 20 graus ");
            d.setText("PA e perfil ");
            e.setText("Perfil e oblíqua ");
            alt = R.id.a;
        }
        if (question == 240) {
            questaoTextView.setText("Assinale a alternativa que indica a técnica radiográfica intrabucal mais indicada para diagnóstico de cárie dentária. ");
            a.setText("Telerradiografia Lateral ");
            b.setText("Oclusal total ");
            c.setText("Interproximal ou Bite-Wing ");
            d.setText("Panorâmica ");
            e.setText("Periapical ");
            alt = R.id.a;
        }
        if (question == 241) {
            questaoTextView.setText("Dos raios-x abaixo, quais precisam fazer parte da Documentação Ortodôntica Odontológica? ");
            a.setText("Panorâmica e Telerradiografia Lateral ");
            b.setText("Interproximal e Póstero-Anterior (PA) ");
            c.setText("ATM 4 tomadas e Panorâmica ");
            d.setText("Periapical e Interproximal ");
            e.setText("Telerradiografia Lateral e ATM 4 tomadas ");
            alt = R.id.b;
        }
        if (question == 242) {
            questaoTextView.setText("Radiografia mais utilizada na área odontológica e que mostra todos os dentes, côndilos, maxila, mandíbula, seios maxilares e região nasal, tudo em uma única tomada: ");
            a.setText("Periapical ");
            b.setText("Telerradiografia Lateral ");
            c.setText("Panorâmica");
            d.setText("Oclusal ");
            e.setText("Interproximal ");
            alt = R.id.d;
        }
        if (question == 243) {
            questaoTextView.setText("Incidências básicas de rotina no estudo radiológico dos seios da face encontram-se na alternativa ");
            a.setText("Caldwell e lateral direito");
            b.setText("Perfil esquerdo e Water ");
            c.setText("Mento-naso e oblíquas ");
            d.setText("Fronto-naso e mento-naso ");
            e.setText("Hirtz e oblíquas ");
            alt = R.id.c;
        }
        if (question == 244) {
            questaoTextView.setText("Para se descartarem calcificações e massas abaixo das clavículas pela incidência ápico-lordótica, o paciente deve ser posicionado em ");
            a.setText("cifose forçada. ");
            b.setText("decúbito lateral esquerdo. ");
            c.setText("lordose forçada ");
            d.setText("decúbito lateral direito ");
            e.setText("decúbito ventral. ");
            alt = R.id.a;
        }
        if (question == 245) {
            questaoTextView.setText("Que estrutura é focalizada na incidência oblíqua lateral pelo método de Law modificado? ");
            a.setText("A face em PA");
            b.setText("O processo odontoide em PA");
            c.setText("A mastoide em perfil");
            d.setText("A sela túrcica em AP ");
            e.setText("O tórax em AP");
            alt = R.id.c;
        }
        if (question == 246) {
            questaoTextView.setText("Definindo-se meios de contraste, tem-se que são substâncias");
            a.setText("capazes de melhorar o contraste das imagens obtidas em exames radiológicos e diagnosticar áreas tensionadas. ");
            b.setText("radiodensas, capazes de melhorar a definição das imagens obtidas em exames radiológicos e diagnosticar áreas tensionadas.");
            c.setText("capazes de melhorar a nitidez das imagens obtidas em exames radiológicos e diagnosticar áreas lesionadas.");
            d.setText("capazes de reduzir o contraste das imagens obtidas em exames radiológicos e diagnosticar áreas lesionadas");
            e.setText("capazes de aumentar a opacidade das imagens obtidas em exames radiológicos.");
            alt = R.id.a;
        }
        if (question == 247) {
            questaoTextView.setText("O exame radiológico de passagem renal, que mostra os rins e o trato urinário durante a administração do contraste, é denominado de");
            a.setText("Uretrocistografia.");
            b.setText("Uretrografia. ");
            c.setText("Urografia excretora. ");
            d.setText("Uretrovarredura ");
            e.setText("Uretromengrafia. ");
            alt = R.id.c;
        }
        if (question == 248) {
            questaoTextView.setText("No estudo radiológico da coluna cervical, em um paciente com trauma e suspeita de luxação de vértebras cervicais, qual a incidência mais apropriada? ");
            a.setText("Radiografia em projeção frontal  ");
            b.setText("Radiografia em projeção lateral com raios ortostáticos ");
            c.setText("Radiografia em projeção lateral com raios horizontais ");
            d.setText("Radiografias oblíquas ");
            e.setText("Radiografia em projeção lateral com hiperflexão do pescoço");
            alt = R.id.c;
        }
        if (question == 249) {
            questaoTextView.setText("Um procedimento radiográfico de coluna cervical básica AP deve ");
            a.setText("ter raio central paralelo à LGM.");
            b.setText("ter raio central com uma angulação de 15º a 20º, incidindo próximo a C5.");
            c.setText("apresentar na imagem de T1 até T7. ");
            d.setText("utilizar cerca de 20 kVp. ");
            e.setText("ter rotação de 30º para a esquerda ");
            alt = R.id.a;
        }
        if (question == 250) {
            questaoTextView.setText("Um médico solicitou uma imagem para visualização do septo nasal ósseo pela projeção PA com método de Caldwell na estativa. Para executar esse procedimento, o operador deve ");
            a.setText("utilizar o raio centralizado ao chassis, saindo no násio, angulado 15º caudal.");
            b.setText("centralizar o raio central na linha glabeloalveolar. ");
            c.setText("alinhar o raio central perpendicular ao filme.");
            d.setText("posicionar o raio central perpendicular ao chassis ou à LIOM.");
            e.setText("centralizar o raio central na proeminência zigomática.");
            alt = R.id.b;
        }
        if (question == 251) {
            questaoTextView.setText("Com relação à identificação dos filmes radiográficos, assinale a alternativa CORRETA.");
            a.setText("Nas radiografias em ortostatismo, a identificação deve ser posicionada no canto superior direito do filme.");
            b.setText("Quando a radiografia for realizada com paciente em decúbito dorsal, sua identificação deverá estar localizada, por convenção, no canto superior direito do paciente.");
            c.setText("A radiografia realizada com o paciente sentado deve ter identificação à direita do paciente, porém no canto inferior no filme ");
            d.setText("A identificação dos filmes deve ser feita, por convenção, do lado esquerdo do paciente. ");
            e.setText("O filme radiográfico não deve ser identificado com o registro do paciente, evitando-se, assim, quebra de sigilo dos exames entre pacientes atendidos no serviço de radiologia. ");
            alt = R.id.c;
        }
        if (question == 252) {
            questaoTextView.setText("Os filmes radiográficos intraorais são marcados com um pequeno ponto de elevação (pit localizador). Assinale a alternativa que apresenta, corretamente, a finalidade dessa marcação para as tomadas radiográficas.");
            a.setText("Demonstrar para qual lado está posicionada a lâmina de chumbo que protege a imagem das radiações secundárias.");
            b.setText("Identificar a face do filme a ser exposta aos Raios X e fixa pelo paciente.");
            c.setText("Indicar que essa película é destinada a duplas exposições e contém duas películas de filme");
            d.setText("Orientar as imagens dos lados direito e esquerdo do paciente, ficando o lado convexo voltado para o observador.");
            e.setText("O objeto e o receptor devem estar posicionados com um ângulo de até 10◦ para a compensação pela técnica periapical da bissetriz.");
            alt = R.id.d;
        }
        if (question == 253) {
            questaoTextView.setText("Na cabeça, mais especificadamente na região das mastoides, como se denomina a pequena câmara oval formada pelo sáculo e pelo utrículo?");
            a.setText("cóclea");
            b.setText("vestíbulo");
            c.setText("canal semicircular");
            d.setText("bigorna");
            e.setText("estribo");
            alt = R.id.b;
        }
        if (question == 254) {
            questaoTextView.setText("O vômer é um osso delgado, de forma triangular, que forma a parte inferoposterior de qual estrutura anatômica?");
            a.setText("septo nasal");
            b.setText("órbita");
            c.setText("sela turca");
            d.setText("coluna cervical");
            e.setText("rochedo");
            alt = R.id.a;
        }
        if (question == 255) {
            questaoTextView.setText("De acordo com Biasoli Jr., no estudo radiológico da bacia, a incidência anteroposterior (AP) com inclinação cefálica do raio central, de aproximadamente 30º, cerca de 5cm abaixo da sínfise púbica recebe o nome de:");
            a.setText("Ferguson");
            b.setText("Lowenstein");
            c.setText("Taylor");
            d.setText("Van Rosen");
            e.setText("Tunnel View");
            alt = R.id.c;
        }
        if (question == 256) {
            questaoTextView.setText("Segundo Bortranger, existem vários tipos e classificações das articulações. A articulação formada por um processo ósseo semelhante a um eixo, que é cercado por um anel de ligamentos e/ou estruturas ósseas, permitindo movimentos de rotação em torno de um único eixo, tendo como exemplo as articulações radioulnares proximal e distal do antebraço, é classificada como: ");
            a.setText("planar");
            b.setText("gínglimo");
            c.setText("trocoide");
            d.setText("elipsoide");
            e.setText("selar");
            alt = R.id.c;
        }
        if (question == 257) {
            questaoTextView.setText("O exame que avalia a coluna lombar permitindo uma medida NÃO invasiva da massa óssea, sendo a dose cutânea de radiação muito baixa é a:");
            a.setText("escanometria");
            b.setText("cintilografia");
            c.setText("ressonância magnética");
            d.setText("mielografia");
            e.setText("densitometria");
            alt = R.id.e;
        }
        if (question == 258) {
            questaoTextView.setText("Os raios X que saem pela janela da cúpula (carcaça) de uma ampola de raios X, são denominados feixe útil de radiação e corresponde a qual porcentagem de toda a radiação gerada no tubo de raios X? ");
            a.setText("5");
            b.setText("10");
            c.setText("25");
            d.setText("50");
            e.setText("75");
            alt = R.id.b;
        }
        if (question == 259) {
            questaoTextView.setText("De acordo com Bortranger, a classificação de Salter-Harris é usada para descrever a gravidade e a indicação racional do prognóstico de fraturas do tipo:");
            a.setText("avulsão");
            b.setText("compressão");
            c.setText("patológica");
            d.setText("cominutiva");
            e.setText("epifisária");
            alt = R.id.b;
        }
        if (question == 260) {
            questaoTextView.setText("Como é denominado, de acordo com Bortranger, o procedimento urográfico no qual o meio de contraste iodado é injetado por cateter no sistema pielocalicinal, estando o paciente sedado ou anestesiado, em posição de litotomia modificada, com objetivos de se determinar a localização de cálculos urinários ou outros tipos de obstrução?");
            a.setText("urografia excretora");
            b.setText("urografia retrógrada");
            c.setText("uretrocistografia miccional");
            d.setText("cistografia retrógrada");
            e.setText("nefrotomografia");
            alt = R.id.a;
        }
        if (question == 261) {
            questaoTextView.setText("Dos fatores de exposição radiográfica que são controlados pelo operador (técnico, tecnólogo ou médico), qual determina a energia (qualidade) do feixe de radiação?");
            a.setText("miliamperagem");
            b.setText("tempo");
            c.setText("miliamperagem por segundo");
            d.setText("quilovolt");
            e.setText("distância");
            alt = R.id.d;
        }
        if (question == 262) {
            questaoTextView.setText("A discrepância de comprimento dos ossos longos dos membros superiores é menos comum do que a dos membros inferiores. De acordo com Bortranger, como é denominado o exame que permite a mensuração dos ossos longos dos membros superiores e no qual são feitas três exposições nas articulações do ombro, cotovelo e punho, sendo cada lado radiografado separadamente?");
            a.setText("cintilografia");
            b.setText("goniometria");
            c.setText("ortorradiolgrafia");
            d.setText("escanometria");
            e.setText("planigrafia");
            alt = R.id.c;
        }
        if (question == 263) {
            questaoTextView.setText("O licenciamento dos estabelecimentos que empregam Raios X diagnósticos, assim como a fiscalização do cumprimento da Portaria n° 453/98 do Ministério da Saúde sobre Radioproteção é de competência de quais órgãos dos estados, Distrito Federal e dos municípios? ");
            a.setText("vigilância sanitária");
            b.setText("secretaria de saúde");
            c.setText("policia federal");
            d.setText("policia militar");
            e.setText("corpo de bombeiros");
            alt = R.id.a;
        }
        if (question == 264) {
            questaoTextView.setText("De acordo com a Portaria n° 453/98, como é denominado o princípio de proteção radiológica que estabelece que as instalações e as práticas devem ser planejadas, implantadas e executadas de modo que a magnitude das doses individuais, o número de pessoas expostas e a probabilidade de exposições acidentais sejam tão baixos quanto razoavelmente exequíveis?");
            a.setText("justificação");
            b.setText("otimização");
            c.setText("limitação");
            d.setText("prevenção");
            e.setText("irradiação");
            alt = R.id.b;
        }
        if (question == 265) {
            questaoTextView.setText("De acordo com a Portaria n° 453/98, a presença de acompanhantes durante procedimentos radiológicos somente é permitida quando sua participação for imprescindível para conter, confortar ou ajudar o paciente. Durante as exposições, é obrigatório, ao acompanhante, o uso de vestimenta de proteção individual (compatível com o procedimento radiológico) cujo equivalente de chumbo seja de, no mínimo:");
            a.setText("0,1mm ");
            b.setText("0,15mm ");
            c.setText("0,20mm ");
            d.setText("0,25mm ");
            e.setText("0,50mm ");
            alt = R.id.d;
        }
        if (question == 266) {
            questaoTextView.setText("O capítulo 4 - “Requisitos Específicos, Referente aos Equipamentos”, adicionado a portaria 453, de 1º de junho de l998 estabelecidas no Brasil pela Secretaria de Vigilância Sanitária do Ministério da Saúde, afirma que os equipamentos devem possuir ");
            a.setText("sistema para impedir que a distância foco-pele seja inferior a 50cm para equipamentos fixos. ");
            b.setText("cabo disparador com comprimento mínimo de 2m, nos equipamentos móveis. ");
            c.setText("para a radiologia convencional, sistemas de gerador autorretificados ou retificação de meia onda. ");
            d.setText("suporte de cabeçote fixo, de modo a manter o tubo estável durante uma exposição. ");
            e.setText("blindagem do cabeçote de modo a garantir nenhum nível de radiação de fuga. ");
            alt = R.id.b;
        }
        if (question == 267) {
            questaoTextView.setText("De acordo com o capítulo IX, Art. 25 - “Trabalho em equipe” do Código de Ética Profissional dos Técnicos em Radiologia, podemos afirmar que ");
            a.setText("o trabalho em equipe isenta a responsabilidade dos profissionais empenhados em suas funções específicas. ");
            b.setText("o trabalho em equipe restringe a responsabilidade dos profissionais empenhados em suas funções específicas. ");
            c.setText("o trabalho em equipe não diminui a responsabilidade dos profissionais empenhados em suas funções específicas. ");
            d.setText("o trabalho em equipe amplia a responsabilidade dos profissionais empenhados em suas funções específicas. ");
            e.setText("o trabalho em equipe distribui a responsabilidade dos profissionais empenhados em suas funções específicas. ");
            alt = R.id.c;
        }
        if (question == 268) {
            questaoTextView.setText("Assinale a alternativa que apresenta corretamente “Uma das convenções adotadas na identificação das radiografias”. ");
            a.setText("A identificação, sempre que possível, deve acompanhar o lado direito do observador da imagem. ");
            b.setText("Quando o paciente está na posição ortostática, a identificação ficará à direita do paciente e na parte inferior da imagem. ");
            c.setText("Nas incidências em perfil, a identificação na parte inferior da imagem identifica o lado direito do paciente. ");
            d.setText("Nas incidências em perfil, a identificação na parte anterior da imagem identifica o lado esquerdo do paciente. ");
            e.setText("Quando o paciente está em decúbito, a identificação ficará na parte superior da imagem. ");
            alt = R.id.d;
        }
        if (question == 269) {
            questaoTextView.setText("Com geradores trifásicos nos aparelhos de raios X, obtemos ");
            a.setText("menor tempo de exposição e voltagem constante. ");
            b.setText("menor calor a menor tempo de exposição. ");
            c.setText("maior tempo de exposição e voltagem pulsada. ");
            d.setText("menor calor e voltagem pulsada. ");
            e.setText("menor tempo de exposição e voltagem pulsada. ");
            alt = R.id.a;
        }
        if (question == 270) {
            questaoTextView.setText("Após atravessar o objeto e antes de atingir o anteparo, o feixe de raios X atenuado cria uma imagem, denominada imagem ");
            a.setText("latente. ");
            b.setText("luminosa. ");
            c.setText("radiante. ");
            d.setText("especular. ");
            e.setText("radioscópica. ");
            alt = R.id.c;
        }
        if (question == 271) {
            questaoTextView.setText("As caixas de filmes radiográficos ainda não utilizados (virgens e fechados) devem ser armazenados em que condição? ");
            a.setText("Na câmara escura, empilhadas horizontalmente. ");
            b.setText("Em lugar arejado, empilhadas horizontalmente sem se preocupar com a luz, pois o material está em um saco protegido. ");
            c.setText("Na sala de exames, colocados na vertical. ");
            d.setText("Em local arejado e fresco, protegidas do calor e radiação, posicionadas na vertical. ");
            e.setText("Na câmara escura protegidas do calor e umidade. ");
            alt = R.id.d;
        }
        if (question == 272) {
            questaoTextView.setText("Um filme irregularmente posicionado no chassis provocando um mau contato com os écrans, ocasiona qual efeito? ");
            a.setText("Diminuição do contraste. ");
            b.setText("Aumento do contraste. ");
            c.setText("Redução na densidade óptica. ");
            d.setText("Imagem de eletricidade estática. ");
            e.setText("Perda de nitidez da imagem. ");
            alt = R.id.e;
        }
        if (question == 273) {
            questaoTextView.setText("Qual é a diferença entre a “grade focalizada” e a “grade não-focalizada”? ");
            a.setText("A grade não focalizada possui um número menor de lâminas de chumbo. ");
            b.setText("A grade não focalizada possui lâminas de chumbo mais espessas. ");
            c.setText("A grade focalizada possui lâminas de chumbo com uma angulação convergindo para um determinado ponto e a grade não focalizada as lâminas são paralelas. ");
            d.setText("A grade focalizada possui lâminas de chumbo paralelas e a grade não focalizada possui lâminas de chumbo com uma angulação convergindo para um determinado ponto. ");
            e.setText("A grade focalizada possui lâminas de chumbo de maior altura. ");
            alt = R.id.c;
        }
        if (question == 274) {
            questaoTextView.setText("O uso do chumbo como material de proteção aos raios X se deve ");
            a.setText("a sua maleabilidade. ");
            b.setText("pela sua não interação com a radiação. ");
            c.setText("a sua grande densidade. ");
            d.setText("a sua pouca densidade. ");
            e.setText("a sua facilidade de manuseio. ");
            alt = R.id.c;
        }
        if (question == 275) {
            questaoTextView.setText("Para suprimir as radiações de baixa energia do feixe de raios X, utilizamos ");
            a.setText("grade antidifusora. ");
            b.setText("diafragma de chumbo. ");
            c.setText("colimador. ");
            d.setText("filtro de alumínio. ");
            e.setText("cone de extensão. ");
            alt = R.id.d;
        }
        if (question == 276) {
            questaoTextView.setText("O que deve ser feito para corrigir uma radiografia de má qualidade, em uma imagem muito clara e com pouco contraste? ");
            a.setText("Aumentar a distância foco filme. ");
            b.setText("Reduzir o mAs. ");
            c.setText("Aumentar a kV. ");
            d.setText("Reduzir a kV. ");
            e.setText("Aumentar a distância objeto filme. ");
            alt = R.id.c;
        }
        if (question == 277) {
            questaoTextView.setText("Para demonstrar vesícula biliar e vias biliares, podemos realizar ");
            a.setText("uma radiografia do abdome em perfil esquerdo. ");
            b.setText("uma radiografia do abdome em póstero-anterior e localizada do hipocôndrio esquerdo. ");
            c.setText("uma radiografia de abdome em decúbito ventral com raios horizontais. ");
            d.setText("uma radiografia de abdome em ânteroposterior e localizada do hipocôndrio direito. ");
            e.setText("uma radiografia de abdome em decúbito dorsal com raios horizontais. ");
            alt = R.id.d;
        }
        if (question == 278) {
            questaoTextView.setText("As radiografias de tórax devem ser realizadas em posição ortostática, se a condição do paciente permitir, com o objetivo de ");
            a.setText("ter a possibilidade de o diafragma mover-se mais para baixo, níveis hidroaéreos no tórax podem ser visualizados e pode ser evitado o aumento e hiperemia dos vasos pulmonares. ");
            b.setText("ter maior detalhe dos arcos costais. ");
            c.setText("ter um aumento da densidade pulmonar e densidade da silhueta cardíaca. ");
            d.setText("ter menor magnificação. ");
            e.setText("melhor visualização dos ápices pulmonares. ");
            alt = R.id.a;
        }
        if (question == 279) {
            questaoTextView.setText("Quando as imagens do tórax forem adquiridas por meio do uso de imagem com tecnologia digital os fatores de exposição incluem o uso de ");
            a.setText("kV mais alto e o mAs o mais baixo possível. ");
            b.setText("kV mais baixo e o mAs o mais alto possível. ");
            c.setText("kV moderado e o mAs o mais alto possível. ");
            d.setText("kV mais alto e o mAs moderado. ");
            e.setText("kV mais alto e o mAs mais alto possível. ");
            alt = R.id.a;
        }
        if (question == 280) {
            questaoTextView.setText("Na radiografia do abdome ânteroposterior em leito, realizada para avaliação do posicionamento de sonda enteral, é imperativo que se demostre ");
            a.setText("os músculos psoas. ");
            b.setText("as cristas ilíacas. ");
            c.setText("a base do tórax. ");
            d.setText("os contornos dos rins. ");
            e.setText("a coluna lombar. ");
            alt = R.id.c;
        }
        if (question == 281) {
            questaoTextView.setText("A ascite e o pneumoperitônio, são patologias ou condições patológicas evidenciadas ");
            a.setText("na radiografia simples de abdome. ");
            b.setText("na radiografia simples de abdome em decúbito ventral. ");
            c.setText("na rotina de abdome agudo. ");
            d.setText("na radiografia do tórax. ");
            e.setText("na radiografia contrastada do cólon. ");
            alt = R.id.c;
        }
        if (question == 282) {
            questaoTextView.setText("Na realização de uma urografia excretora, qual posicionamento pode ser utilizado para substituir a compressão ureteral, para pacientes com contraindicações para a compressão abdominal? ");
            a.setText("Posição de decúbito ventral. ");
            b.setText("Posição de decúbito lateral. ");
            c.setText("Posição de Trendelenburg. ");
            d.setText("Posição de Sim. ");
            e.setText("Posição de Fowler. ");
            alt = R.id.c;
        }
        if (question == 283) {
            questaoTextView.setText("Qual é a angulação da ampola para a posição AP AXIAL DE L5 A S1 : COLUNA LOMBAR? ");
            a.setText("Angular o RC cefálico, 30° (homens) a 35° (mulheres). ");
            b.setText("Angular o RC cefálico, 35° (homens) a 35° (mulheres). ");
            c.setText("Angular o RC cefálico, 30° (homens) a 30° (mulheres). ");
            d.setText("Angular o RC cefálico, 35° (homens) a 30° (mulheres). ");
            e.setText("Angular o RC cefálico, 40° (homens) a 35° (mulheres). ");
            alt = R.id.a;
        }
        if (question == 284) {
            questaoTextView.setText("O contraste dos tecidos moles é muito melhor na TC e na RM do que no processo convencional de obtenção de imagens em filmes. Essa capacidade de mostrar o contraste dos tecidos moles é chamada de ");
            a.setText("resolução espacial. ");
            b.setText("resolução de contraste. ");
            c.setText("resolução de recepção. ");
            d.setText("absorção de contraste. ");
            e.setText("absorção de sinal. ");
            alt = R.id.b;
        }
        if (question == 285) {
            questaoTextView.setText("Em RM, alguns núcleos do corpo absorvem e reemitem ondas de rádio de frequências específicas quando estão sob a influência de um campo magnético. Esses sinais de rádio reemitidos contêm informações sobre o paciente que são capturadas por ");
            a.setText("uma interface. ");
            b.setText("um transmissor. ");
            c.setText("um magneto. ");
            d.setText("um conversor. ");
            e.setText("um receptor ou antena. ");
            alt = R.id.e;
        }
        if (question == 286) {
            questaoTextView.setText("Em RM, a velocidade de precessão de um próton em um campo magnético ");
            a.setText("aumenta à medida que a intensidade do campo magnético cresce. ");
            b.setText("diminui à medida que a intensidade do campo magnético cresce. ");
            c.setText("aumenta à medida que a intensidade do campo magnético diminui. ");
            d.setText("não se altera à medida que a intensidade do campo magnético cresce. ");
            e.setText("não se altera com a intensidade do campo magnético. ");
            alt = R.id.a;
        }
        if (question == 287) {
            questaoTextView.setText("Na RM, quando um pulso de radiofrequência é desligado, os núcleos começam a voltar para uma configuração mais aleatória. Esse processo é chamado de ");
            a.setText("radiofrequência. ");
            b.setText("ruído aleatório. ");
            c.setText("relaxação. ");
            d.setText("precessão. ");
            e.setText("relação sinal/ruído. ");
            alt = R.id.c;
        }
        if (question == 288) {
            questaoTextView.setText("Embora a gravidez não seja uma contraindicação absoluta para um exame de RM, ela é considerada uma contraindicação no/na ");
            a.setText("segunda semana. ");
            b.setText("primeiro mês. ");
            c.setText("primeiro bimestre. ");
            d.setText("primeiro trimestre. ");
            e.setText("primeiro semestre. ");
            alt = R.id.d;
        }
        if (question == 289) {
            questaoTextView.setText("Nos termos relacionados à RM, “recuperação da inversão” significa ");
            a.setText("sequência de pulsos de RF para RM na qual a magnetização final é invertida e retoma o equilíbrio com a emissão de um sinal de RM. ");
            b.setText("recurso para variar a intensidade do campo magnético estático. ");
            c.setText("campo magnético com gradiente aplicado por um tempo curto após um pulso seletivo de excitação na direção oposta ao gradiente utilizado para a excitação seletiva. ");
            d.setText("método para melhorar a relação sinal/ruído. ");
            e.setText("aplicação repetida de pulsos de radiofrequência. ");
            alt = R.id.a;
        }
        if (question == 290) {
            questaoTextView.setText("Quanto aos artefatos em exames de Ressonância Magnética (RM), é correto afirmar que ");
            a.setText("artefato de sombreamento: produz perda na intensidade do sinal devido à excitação irregular dos núcleos do corpo do paciente em função de pulsos de RF (radiofrequência) aplicados em ângulos diferentes de 90° e 180°. Verifique se é a bobina correta e afaste o corpo do paciente da bobina. ");
            b.setText("artefato de movimento, a solução é mudança de FOV (campo de visão), o que pode exigir um filtro anti aliasing, ou usar a sincronização, entretanto isso pode aumentar o tempo de exame. ");
            c.setText("artefato de aliasing: produz uma imagem no qual as estruturas anatômicas existentes fora do FOV são mapeadas dentro dele. Se reduzir o FOV aumenta-se a resolução. ");
            d.setText("artefato de ângulo mágico: são sinais de baixa intensidade em tecidos que contém colágeno (tendões) com TE (tempo de eco) curtos, por redução das interações spin-spin até zerarem. A solução ideal é a mudança do TR (tempo de repetição). ");
            e.setText("artefato de deslocamento químico: reduza a largura de banda, mas reduza ao TE mínimo; ou aumente o FOV, mas isso irá reduzir a SNR (razão sinal ruído). ");
            alt = R.id.a;
        }
        if (question == 291) {
            questaoTextView.setText("A expansão excessiva da densidade dos tecidos fibrosos, a acumulação de líquidos ou deslocamento de tecidos aéreos dos pulmões, caracterizando a necessidade de aumento nos fatores de exposição para definição adequada de todo o parênquima pulmonar é característica das seguintes patologias pulmonares: ");
            a.setText("pneumonia, enfisema, hidropneomotórax. ");
            b.setText("pneumotórax, pneumoconiose, pneumonia. ");
            c.setText("efusão pleural, pneumoconioses, tuberculose pulmonar. ");
            d.setText("pneumoconioses, efusão pleural, enfisema. ");
            e.setText("hidropneumotórax, pneumonia, enfisema. ");
            alt = R.id.c;
        }
        if (question == 292) {
            questaoTextView.setText("Quais considerações a seguir são relevantes na avaliação do paciente para a determinação da carta técnica de exposições? ");
            a.setText("O valor da energia (kVp) ótima recomendada para penetração de Iodo: pelo menos 90 kVp; Bário: pelo menos 90 kVp (com exceção de exames no esôfago e estudos com ar como contraste que deve ser em torno de 110 kVp). ");
            b.setText("A influência da idade nos espectros de atenuação se manifesta nas progressivas modificações do volume dos ossos, da transparência dos pulmões e da calcificação do esqueleto do organismo em desenvolvimento. ");
            c.setText("Condições patológicas como ascite, tumores volumosos e grandes infiltrações pulmonares aumentam a atenuação e alongam os espectros de atenuação, exigindo mais mAs para melhorar a densidade. ");
            d.setText("Pacientes brevilíneos tem o cólon transverso bastante alto, e o intestino grosso estende-se até a periferia da cavidade abdominal. O estômago encontra-se bastante alto, assumindo uma posição quase vertical. ");
            e.setText("Pacientes longilíneos tem pulmões estreitos, mais longos e com o diafragma baixo. Isso faz com que o intestino grosso situe-se em posição muito baixa no abdômen e o estômago apresenta-se em forma de J e encontrando-se, geralmente, na região inferior do abdômen. ");
            alt = R.id.e;
        }
        if (question == 293) {
            questaoTextView.setText("Em exames de RM, para minimizar o tempo de exame é possível aplicar diversos processos, entretanto cada um deles apresenta uma consequência que deve ser considerada em cada caso. Sobre o assunto, assinale a alternativa correta. ");
            a.setText("Na redução do tempo de repetição (TR): aumenta-se a ponderação em T2. ");
            b.setText("Na redução do TR: aumenta-se a razão sinal ruído (SNR). ");
            c.setText("Na redução do tamanho da matriz: reduz-se a SNR. ");
            d.setText("Na redução do tamanho da matriz: aumenta-se a SNR. ");
            e.setText("No aumento do número de excitações (NEX): aumenta-se a SNR. ");
            alt = R.id.d;
        }
        if (question == 294) {
            questaoTextView.setText("Com todos os outros fatores inalterados, se o mAs for aumentado em 50%, o contraste da imagem irá ");
            a.setText("aumentará em proporção direta. ");
            b.setText("reduzirá em proporção direta. ");
            c.setText("não sofrerá nenhuma alteração. ");
            d.setText("pode alterará ligeiramente, mas não de forma a tornar a mudança visível. ");
            e.setText("pode ser afetado indiretamente, mas não controlá-lo diretamente. ");
            alt = R.id.c;
        }
        if (question == 295) {
            questaoTextView.setText("Sobre a rotina de avaliação do divertículo de Meckel em exames de Medicina Nuclear, assinale a alternativa correta. ");
            a.setText("Requer jejum absoluto de 2 a 3 h antes do exame. ");
            b.setText("O exame indicado é a cintilografia com pertecnetato- 99mTc. ");
            c.setText("O exame indicado é a cintilografia com cloreto de Tálio 201. ");
            d.setText("O exame indicado é a cintilografia com 99m Tc- DMSA. ");
            e.setText("A hipercaptação aparece por volta de 15 a 20 minutos após a administração endovenosa do fármaco. ");
            alt = R.id.b;
        }
        if (question == 296) {
            questaoTextView.setText("Quanto aos fenômenos de fluxo em RM, assinale a alternativa correta. ");
            a.setText("Os efeitos de tempo de vôo produzem sempre um vazio de sinal. ");
            b.setText("A intensidade do sinal do lúmen do vaso não é afetada pelo mecanismo de fluxo. ");
            c.setText("Os efeitos do fenômeno de corte de entrada produzem uma intensidade similar de sinal para núcleos em movimento. ");
            d.setText("A refasagem do eco par na sequência spin eco pode ser empregada para reduzir artefatos em imagens ponderadas em T2. ");
            e.setText("A refasagem do momento gradiente é mais efetiva em fluxos laminares lentos. ");
            alt = R.id.d;
        }
        if (question == 297) {
            questaoTextView.setText("Na radiologia CR, após a placa de fósforo foto estimulável ter sido escaneada pelo tubo leitor da fotomultiplicadora (FM), a placa é exposta a um a luz de alta intensidade com a finalidade de ");
            a.setText("limpar o sistema de transporte de qualquer sombra de íons positivos. ");
            b.setText("limpar qualquer centro de imagem latente remanescente da placa de fósforo. ");
            c.setText("realinhar o espelho laser de baixa densidade para o tubo da FM. ");
            d.setText("amplificar o sinal eletrônico do tubo da FM antes de passá-lo para o monitor de visualização. ");
            e.setText("elevar os elétrons a um estado metaestável antes da conversão do sinal analógico para o digital. ");
            alt = R.id.b;
        }
        if (question == 298) {
            questaoTextView.setText("Sobre a rotina de exame de coluna lombar, sacro e cóccix, assinale a alternativa correta. ");
            a.setText("O cóccix médio está aproximadamente ao nível da sínfise púbica ou do trocanter menor, que está cerca de 2,5 cm superior ao nível da sínfise púbica. ");
            b.setText("Na incidência PA da coluna lombar: curvatura lombar natural, maior dose ovariana, ampliação das vértebras lombares. ");
            c.setText("Na incidência AP da coluna lombar: joelhos flexionados, menor curvatura lombar, e coluna vertebral paralela ao receptor, menor dose ovariana. ");
            d.setText("Os fatores de exposição devem contemplar a compensação das variações da espessura do paciente e colimação rigorosa, de modo a limitar a radiação dispersa que degrada o contraste da imagem. ");
            e.setText("A distância foco receptor pode variar entre 80 a 90 cm, de modo a reduzir a ampliação. ");
            alt = R.id.d;
        }
        if (question == 299) {
            questaoTextView.setText("Na radiologia digital computadorizada (CR), quanto à centralização do campo e requisitos de colimação, qual das situações a seguir é mais provável que resulte em erros na análise do histograma? ");
            a.setText("Colimação menor do que a placa de imagem. ");
            b.setText("Usar um campo colimado, mas em diagonal. ");
            c.setText("Um lado do campo colimado está fora da borda da placa. ");
            d.setText("Tentar fazer uma projeção bilateral de extremidades inferiores. ");
            e.setText("Usar um campo de colimação que expõe apenas 40% da placa de imagem. ");
            alt = R.id.c;
        }
        if (question == 300) {
            questaoTextView.setText("Para a otimização dos procedimentos em tomografia computadorizada para pacientes pediátricos é importante que os protocolos contemplem, aproximadamente, ");
            a.setText("os protocolos devem ser específicos e ajustados quanto ao valor de: mA, pitch e intervalo de reconstrução. ");
            b.setText("nos casos de sedação, jejum de pelo menos 4h para líquidos, incluindo o leite materno. ");
            c.setText("na avaliação de nefrolitíase, a varredura deve ocorrer do topo dos rins até a bexiga, com uso de contraste oral ou endovenoso. ");
            d.setText("na avaliação do tórax, o pitch deve estar em torno de 0,75, devido ao aumento de detecção de nódulos pela sobreposição dos slices. ");
            e.setText("uso de 2 a 3 ml/kg de meio de contraste, preferencialmente não iônico, até um máximo de 150 ml. ");
            alt = R.id.e;
        }
        if (question == 301) {
            questaoTextView.setText("NÂO é função do indivíduo ocupacionalmente exposto (IOE) em um serviço de Medicina Nuclear ");
            a.setText("utilizar adequadamente os instrumentos de medição da radiação fornecidos pelo Serviço de Medicina Nuclear. ");
            b.setText("identificar condições sob as quais possam ocorrer exposições potenciais, revisando e corrigindo os procedimentos de segurança aplicáveis. ");
            c.setText("antes de administrar o radiofármaco ao paciente injetado, verificar a realização e registro do controle de qualidade dos radiofármacos. ");
            d.setText("antes de administrar o radiofármaco ao paciente injetado, confirmar a identificação do paciente, verificar se a atividade e o radiofármaco estão em conformidade com o prescrito pelo médico nuclear. ");
            e.setText("verificar a existência de contaminação radioativa nos instrumentos de medição da radiação, bem como nos equipamentos de diagnóstico. ");
            alt = R.id.b;
        }
        if (question == 302) {
            questaoTextView.setText("Em relação à avaliação dos órgãos intratorácicos em exames de raios X, assinale a alternativa correta. ");
            a.setText("Em ortostática, os gases do estômago e ângulo esplênico formam níveis hidroaéreos nas porções inferiores do abdome. ");
            b.setText("Em ortostática, as cúpulas são mais baixas e os vasos pulmonares são mais espessos nos terços superiores dos pulmões quando comparados às bases. ");
            c.setText("Nos decúbitos, os vasos pulmonares são dilatados nos terços inferiores dos pulmões e as cúpulas frênicas são mais elevadas. ");
            d.setText("No decúbito direito (DD), os gases do estômago estão situados no corpo e no antro, e, por vezes, o sigmoide e o ceco também contém gases. ");
            e.setText("No hemitórax esquerdo, PA ou AP, o contorno do mediastino é formado pelo ventrículo esquerdo, parte do átrio esquerdo, artéria pulmonar e artéria subclávia. ");
            alt = R.id.e;
        }
        if (question == 303) {
            questaoTextView.setText("No sistema ósseo, o que constitui um importante ponto de inserção de um tendão ou ligamento, têm aparências variáveis e muitas vezes são confundidos com fraturas? ");
            a.setText("Periósteo. ");
            b.setText("Epífise. ");
            c.setText("Diáfase. ");
            d.setText("Sesamoide. ");
            e.setText("Apófise. ");
            alt = R.id.e;
        }
        if (question == 304) {
            questaoTextView.setText("O PACS (Sistema de arquivamento de imagens médicas) é uma parte do sistema de radiologia digital que está relacionado com ");
            a.setText("a produção de imagens para monitores. ");
            b.setText("a manipulação de imagens para monitores. ");
            c.setText("o arquivamento e transferência de imagens para monitores. ");
            d.setText("a aquisição de imagens para monitores. ");
            e.setText("a aquisição e manipulação de imagens para monitores. ");
            alt = R.id.c;
        }
        if (question == 305) {
            questaoTextView.setText("Para demonstrar tecidos moles em sistemas de Radiologia Computadorizada (CR), qual das combinações de WW – largura de janela e WL – nível de janela é a mais adequada? ");
            a.setText("Alta WW e baixo WL. ");
            b.setText("Baixa WW e alto WL. ");
            c.setText("Alta WW e alto WL. ");
            d.setText("Baixa WW e baixo WL. ");
            e.setText("Moderada WW e Moderado WL. ");
            alt = R.id.a;
        }
        if (question == 306) {
            questaoTextView.setText("Qual é o fenômeno útil para localizar regiões na imagem, alterando-se a angulação do tubo de raios X ou a posição do paciente? ");
            a.setText("Janelamento. ");
            b.setText("Paralaxe. ");
            c.setText("Condensação. ");
            d.setText("Perfusão. ");
            e.setText("Alusão. ");
            alt = R.id.b;
        }
        if (question == 307) {
            questaoTextView.setText("No exame de mamografia, NÂO está relacionado diretamente ao efeito da compressão ");
            a.setText("a redução da espessura da mama proporcionando um tecido mais uniforme. ");
            b.setText("o menor espalhamento de radiação, mais tecido mamário visualizado com detalhes. ");
            c.setText("o uso da paralaxe posicional para caracterizar lesões. ");
            d.setText("o tecido mamário melhor visualizado com a redução da sobreposição dos tecidos. ");
            e.setText("a melhora da visualização de tecidos próximos da parede torácica. ");
            alt = R.id.c;
        }
        if (question == 308) {
            questaoTextView.setText("Mantendo-se todos os demais fatores do exame constantes, a injeção de um meio de contraste positivo irá provocar na nitidez da imagem ");
            a.setText("um aumento. ");
            b.setText("uma redução. ");
            c.setText("nenhuma mudança. ");
            d.setText("a possibilidade de alterar ligeiramente, mas não de forma a tornar a mudança visível. ");
            e.setText("a possibilidade de ser afetado indiretamente, mas não controlá-lo diretamente. ");
            alt = R.id.c;
        }
        if (question == 309) {
            questaoTextView.setText("Alguns artefatos na imagem em radiologia computadorizada (CR) podem ser causados apenas pelo operador, dentre eles estão ");
            a.setText("as linhas brancas e finas nos filmes impressos. ");
            b.setText("as imagens com linhas brancas tipo grade com áreas brancas localizadas. ");
            c.setText("a dupla exposição na placa de imagem. ");
            d.setText("a imagem residual do exame anterior. ");
            e.setText("as linhas pretas ao longo da placa de imagem. ");
            alt = R.id.b;
        }
        if (question == 310) {
            questaoTextView.setText("Radiação é o processo pelo qual uma fonte emite energia que se propaga no espaço. Segundo o dicionário Aurélio: “Qualquer dos processos físicos de emissão e propagação de energia, seja por intermédio de fenômenos ondulatórios, seja por meio de partículas dotadas de energia cinética” ou “Energia que se propaga de um ponto a outro no espaço vazio ou através de um meio material”. O termo radiação se usa para designar a própria energia emitida e também ");
            a.setText("energia em movimento. ");
            b.setText("energia em repouso. ");
            c.setText("calor dissipado. ");
            d.setText("ondas estacionárias. ");
            e.setText("tudo aquilo que é capaz de realizar trabalho. ");
            alt = R.id.a;
        }
        if (question == 311) {
            questaoTextView.setText("O conceito de onda é de fundamental importância para a compreensão de uma série de fenômenos físicos. Quanto à forma de ondas, existe(m) basicamente ");
            a.setText("um tipo de onda: Onda eletromagnética. ");
            b.setText("dois tipos de onda: Ondas Eletromagnéticas e Ondas Longitudinais. ");
            c.setText("dois tipos de onda: Ondas Mecânicas e Ondas Eletromagnéticas. ");
            d.setText("três tipos de onda: Ondas Mecânicas, Ondas Longitudinais e Ondas Transversais. ");
            e.setText("dois tipos de onda: Ondas Mecânicas e Ondas Transversais. ");
            alt = R.id.c;
        }
        if (question == 312) {
            questaoTextView.setText("O átomo é a menor de todas as partículas que compõem elementos químicos, sendo composto por prótons, elétrons e nêutrons. Há um núcleo, onde estão os prótons e os nêutrons, e a eletrosfera, que é formada por elétrons. O número total de prótons no núcleo do átomo é chamado de ");
            a.setText("número quântico, em geral representado pela letra Q. ");
            b.setText("spin, geralmente representado pela letra S. ");
            c.setText("número quântico, geralmente representado pela letra Z. ");
            d.setText("número atômico, em geral representado pela letra Z. ");
            e.setText("número atômico, geralmente representado pela letra A. ");
            alt = R.id.d;
        }
        if (question == 313) {
            questaoTextView.setText("O decaimento radioativo pode ocorrer basicamente de três modos distintos, sendo eles: ");
            a.setText("por emissão positrônica, por emissão beta ou por emissão gama. ");
            b.setText("por emissão alfa, por emissão de elétrons ou por emissão gama. ");
            c.setText("por emissão alfa, por emissão beta ou por emissão gama. ");
            d.setText("por emissão de nêutrons, por emissão beta ou por emissão gama. ");
            e.setText("por emissão alfa, por emissão de prótons ou por emissão gama. ");
            alt = R.id.c;
        }
        if (question == 314) {
            questaoTextView.setText("Dos fatores que afetam a absorção dos Raios-X no corpo humano, assinale a alternativa INCORRETA. ");
            a.setText("Espessura e Densidade. ");
            b.setText("Número Atômico (Z). ");
            c.setText("Meios de Contraste. ");
            d.setText("Kilovoltagem e Filtragem. ");
            e.setText("Composição do Objeto Catódico. ");
            alt = R.id.e;
        }
        if (question == 315) {
            questaoTextView.setText("Qual é a distância em metros que a luz de segurança, utilizada em câmara escura, deve estar em relação ao local de manuseio dos filmes radiográficos? ");
            a.setText("0,5 m. ");
            b.setText("0,75 m. ");
            c.setText("1,2 m. ");
            d.setText("1,7 m. ");
            e.setText("2 m. ");
            alt = R.id.c;
        }
        if (question == 316) {
            questaoTextView.setText("Define-se que o contraste de uma imagem radiográfica ");
            a.setText("é a diferença entre as densidades ópticas entre máxima (preto) e mínima (branco) da imagem radiográfica. ");
            b.setText("corresponde a uma baixa definição dos contornos nela contidos. ");
            c.setText("é obtido através do aumento do tamanho da grade. ");
            d.setText("é obtido pelo movimento voluntário do paciente. ");
            e.setText("é correspondente ao tamanho do campo irradiado. ");
            alt = R.id.a;
        }
        if (question == 317) {
            questaoTextView.setText("Sobre o ponto focal, assinale a alternativa correta. ");
            a.setText("O ponto focal é a espessura do feixe de raios-x que chega ao filme. ");
            b.setText("O ponto focal é o copo de focagem do catodo. ");
            c.setText("O ponto focal é a região do anódio onde ocorre o impacto dos elétrons emitido pelo catódio. ");
            d.setText("O ponto focal é a janela no tudo por onde sai o feixe de raios-x. ");
            e.setText("O ponto focal é relacionado com a técnica radiográfica. ");
            alt = R.id.c;
        }
        if (question == 318) {
            questaoTextView.setText("Para uma radiografia de tórax em póstero-anterior, onde a anatomia a ser estudada é o pulmão de um paciente com 90 kg de peso, 27 de espessura, utilizando-se de um aparelho de raios-X cuja constante seja 35, devemos utilizar qual quilovoltagem? ");
            a.setText("89. ");
            b.setText("90. ");
            c.setText("92. ");
            d.setText("100. ");
            e.setText("80. ");
            alt = R.id.a;
        }
        if (question == 319) {
            questaoTextView.setText("Um paciente em posição oblíqua, de costas para o tubo de raios-X com o lado esquerdo mais afastado do Buck, corresponde à incidência ");
            a.setText("Oblíqua ântero-posterior direita. ");
            b.setText("Tangencial direita. ");
            c.setText("Oblíqua póstero-anterior esquerda. ");
            d.setText("Oblíqua póstero anterior direita. ");
            e.setText("Oblíqua ântero-posterior esquerda. ");
            alt = R.id.d;
        }
        if (question == 320) {
            questaoTextView.setText("A intensidade de radiação secundária, produzida pela interação do feixe de raios-x com o corpo, será ");
            a.setText("menor quanto maior for o volume do corpo atravessado. ");
            b.setText("menor quanto menor for a densidade do corpo atravessado. ");
            c.setText("proporcional à energia do feixe de raios-X, independente do volume do corpo atravessado. ");
            d.setText("maior quanto maior for a espessura do corpo atravessado. ");
            e.setText("menor quanto maior for a energia do feixe de radiação. ");
            alt = R.id.d;
        }
        if (question == 321) {
            questaoTextView.setText("A cultura de segurança pode ser definida como o conjunto de características e atitudes em organizações e indivíduos que estabelece como prioridade dominante, que assuntos relacionados à segurança de instalações nucleares ou radiativas recebam a atenção assegurada por sua relevância. Assim, deve ser fomentada e mantida uma cultura de segurança para encorajar atitudes de questionamento e aprendizado em relação à segurança e proteção radiológica e para desencorajar a complacência, de modo a assegurar que, EXCETO ");
            a.setText("sejam estabelecidas diretrizes e procedimentos para que questões relacionadas à segurança e proteção radiológica sejam identificadas como da mais alta prioridade. ");
            b.setText("sejam prontamente identificados e corrigidos apenas os problemas mais graves que afetem a segurança ou proteção radiológica. ");
            c.setText("sejam claramente definidas as responsabilidades de cada indivíduo em relação à segurança e proteção radiológica, incluindo daqueles que ocupam cargos de direção, e seja assegurado que cada indivíduo receba o treinamento adequado. ");
            d.setText("sejam estabelecidas linhas bem definidas de autoridades para tomadas de decisão em relação à segurança e proteção radiológica. ");
            e.setText("sejam efetivados arranjos organizacionais e linhas de comunicação que resultem num fluxo de informação adequado sobre assuntos pertinentes à segurança e proteção radiológica. ");
            alt = R.id.b;
        }
        if (question == 322) {
            questaoTextView.setText("O objetivo maior da proteção radiológica é evitar a exposição desnecessária do indivíduo à radiação ionizante. Para tanto, algumas regras básicas, fundamentadas essencialmente no bom senso, devem ser seguidas pelos usuários de fontes de radiação ionizante de modo a reduzir a exposição externa e evitar tanto a contaminação externa como a incorporação de material radioativo seja por inalação ou ingestão. Assinale a alternativa que apresenta corretamente algumas regras práticas para evitar exposição desnecessária à radiação em práticas envolvendo o uso de materiais radioativos. ");
            a.setText("Não comer, beber, fumar, se maquiar ou mesmo se pentear no laboratório. ");
            b.setText("Usar vestimenta de proteção (jaleco) e, se necessário, sapatilhas em áreas onde experimentos com radionuclídeos estão sendo conduzidos, permanecendo com essas vestimentas mesmo em áreas livres. ");
            c.setText("Em caso de risco significativo de contaminação das mãos, não se faz necessário usar luvas cirúrgicas, desde que as mãos sejam lavadas antes e depois do manuseio das substancias radioativas. ");
            d.setText("Pipetar soluções radioativas com a boca, porém dentro da capela. ");
            e.setText("Lenços de papel devem estar sempre disponíveis para serem usados como meio efetivo de descontaminação. ");
            alt = R.id.a;
        }
        if (question == 323) {
            questaoTextView.setText("Sendo 250 mR a intensidade dos raios-X a 1 m. Qual será aproximadamente a distância necessária para que essa intensidade se reduza a metade? ");
            a.setText("1,50 m. ");
            b.setText("1,21 m. ");
            c.setText("1,41 m. ");
            d.setText("1,39 m. ");
            e.setText("1,45 m. ");
            alt = R.id.c;
        }
        if (question == 324) {
            questaoTextView.setText("Com relação aos fatores que influenciam na escolha do detector de radiação mais apropriado para a realização de uma determinada medida, assinale a alternativa INCORRETA. ");
            a.setText("Tipo de radiação e intervalo de tempo de medida. ");
            b.setText("Precisão. ");
            c.setText("Exatidão. ");
            d.setText("Resolução. ");
            e.setText("Condições do ambiente. ");
            alt = R.id.e;
        }
        if (question == 325) {
            questaoTextView.setText("A velocidade da regressão tumoral representa o grau de sensibilidade que o tumor apresenta às radiações e depende, fundamentalmente dos seguintes fatores, EXCETO ");
            a.setText("da sua origem celular. ");
            b.setText("do seu grau de diferenciação. ");
            c.setText("da oxigenação. ");
            d.setText("da forma clínica de apresentação. ");
            e.setText("da intervenção no ciclo celular. ");
            alt = R.id.e;
        }
        if (question == 326) {
            questaoTextView.setText("Os isótopos radioativos (cobalto, césio, irídio etc.) ou sais de rádio são utilizados sob a forma de tubos, agulhas, fios, sementes ou placas e geram radiações, habitualmente, gama de diferentes energias, dependendo do elemento radioativo empregado. São aplicados, na maior parte das vezes, de forma intersticial ou intracavitária, constituindo-se na ");
            a.setText("teleterapia cirúrgica, também conhecida por braquiterapia. ");
            b.setText("radioterapia cirúrgica, também conhecida por braquiterapia. ");
            c.setText("teleterapia cirúrgica, também conhecida por bretaterapia. ");
            d.setText("bretaterapia, também conhecida por teleterapia. ");
            e.setText("radioterapia cirúrgica, também conhecida por teleterapia. ");
            alt = R.id.b;
        }
        if (question == 327) {
            questaoTextView.setText("Em relação à Radioterapia, assinale a alternativa INCORRETA. ");
            a.setText("A radioterapia é um método capaz de destruir células tumorais, empregando feixe de radiações ionizantes. Uma dose pré-calculada de radiação é aplicada, em um determinado tempo, a um volume de tecido que engloba o tumor, buscando erradicar todas as células tumorais, com o menor dano possível às células normais circunvizinhas. ");
            b.setText("As radiações não ionizantes são eletromagnéticas ou corpusculares e carregam energia. Ao interagirem com os tecidos, dão origem à elétrons rápidos que ionizam o meio e criam efeitos químicos como a hidrólise da água e a ruptura das cadeias de RNA. ");
            c.setText("A morte celular pode ocorrer então por variados mecanismos, desde a inativação de sistemas vitais para a célula até sua incapacidade de reprodução. ");
            d.setText("A resposta dos tecidos às radiações depende de diversos fatores, tais como: a sensibilidade do tumor à radiação, sua localização e oxigenação, assim como a qualidade e a quantidade da radiação, e o tempo total em que ela é administrada. ");
            e.setText("Para que o efeito biológico atinja maior número de células neoplásicas e a tolerância dos tecidos normais seja respeitada, a dose total de radiação a ser administrada é habitualmente fracionada em doses diárias iguais, quando se usa a terapia externa. ");
            alt = R.id.b;
        }
        if (question == 328) {
            questaoTextView.setText("Com relação às Indicações da Radioterapia, assinale a alternativa correta. ");
            a.setText("Como a radioterapia é um método de tratamento local e/ou regional, pode ser indicada de forma exclusiva ou associada aos outros métodos terapêuticos. ");
            b.setText("A radioterapia pode ser radical (ou curativa) quando o objetivo é apenas a redução tumoral. ");
            c.setText("A radioterapia pode ser paliativa quando se trata a doença em fase subclínica. ");
            d.setText("A radioterapia pode ser remissiva quando se busca a cura total do tumor. ");
            e.setText("A radioterapia pode ser profilática quando se administra a radiação para suprimir a função de um órgão. ");
            alt = R.id.a;
        }
        if (question == 329) {
            questaoTextView.setText("Assinale a alternativa que NÃO corresponde às diversas fontes usadas na radioterapia, seus tipos de radiação gerada e métodos de aplicação. ");
            a.setText("Contatoterapia; Raios-X (superficial); Terapia superficial. ");
            b.setText("Roentgenterapia; Raios-X (ortovoltagem); Terapia semiprofunda. ");
            c.setText("Ressonância Magnética Nuclear; Ondas de Rádios; Macromoléculas. ");
            d.setText("Unidade de cobalto; Raios gama; Teleterapia profunda. ");
            e.setText("Isótopos radioativos; Raios gama e/ou beta; Braquiterapia. ");
            alt = R.id.d;
        }
        if (question == 330) {
            questaoTextView.setText("Em relação à história resumida da Medicina Nuclear, assinale a alternativa referente às três cronologias de eventos que devem ser examinadas. ");
            a.setText("Uma, referente ao desenvolvimento dos equipamentos, outra, à geração de Isótopos utilizáveis em diagnóstico e terapia e a terceira, que diz respeito às investigações laboratoriais com traçadores. ");
            b.setText("Uma, referente aos primeiros pesquisadores, outra, referente ao desenvolvimento dos equipamentos e a terceira, que diz respeito à geração de Isótopos utilizáveis em diagnóstico e terapia. ");
            c.setText("Uma, referente à geração de Isótopos utilizáveis em diagnóstico e terapia, outra, referente às investigações laboratoriais com traçadores e a terceira, que diz respeito aos procedimentos técnicos. ");
            d.setText("Uma, referente ao desenvolvimento dos equipamentos, outra, aos primeiros pesquisadores e a terceira, que diz respeito às investigações laboratoriais com traçadores. ");
            e.setText("Uma, referente ao desenvolvimento dos equipamentos, outra, referente às investigações laboratoriais com traçadores e a terceira, que diz respeito aos procedimentos técnicos. ");
            alt = R.id.a;
        }
        if (question == 331) {
            questaoTextView.setText("A fase laboratorial da Medicina Nuclear tomou impulso a partir de 1956, quando começou a evolução dos processos de análises de fluídos orgânicos, mediante a utilização de traçadores, técnica conhecida como ");
            a.setText("cintilografia. ");
            b.setText("ressonância magnética. ");
            c.setText("radioimuno-análise. ");
            d.setText("tomografia computadorizada. ");
            e.setText("PET (Pósitron Emisson Tomography). ");
            alt = R.id.c;
        }
        if(question==332) {
            questaoTextView.setText("Os isótopos ideais para fins terapêuticos são associados à emissão de Beta, cujos exemplos típicos são ");
            a.setText("Samário 153 (153Sm) e Iodo 131 (131I). ");
            b.setText("Samário 153 (153Sm) e Gálio 67, (67Ga). ");
            c.setText("Gálio 67, (67Ga) e Iodo 131 (131I). ");
            d.setText("Iodo 131 (131I) e Tálio 201 (201Tl). ");
            e.setText("Tálio 201 (201Tl) e Índio 111 (111In). ");
            alt = R.id.a;
        }
        if(question==333) {
            questaoTextView.setText("Existem três tipos de radiações que os radioisótopos podem emitir. Assinale a alternativa que apresenta estas radiações. ");
            a.setText("Raios-X, Pósitrons e Gama. ");
            b.setText("Alfa, Beta e Gama. ");
            c.setText("Alfa, Gama e Raios-X. ");
            d.setText("Beta, Gama e Nêutrons. ");
            e.setText("Pósitrons, Raios-X e Nêutrons. ");
            alt = R.id.b;
        }
        return alt;
    }
}

