import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Write a description of class Graph here.
 *
 * @Aaron Lee
 * @version (a version number or a date)
 */
public class Map
{
    ArrayList<GNode>nodelist;
    public void run() throws Exception
    {
        nodelist = new ArrayList<GNode>();
        //createLettersGraph();
        createCreativeGraph();
    }
    public void createLettersGraph()
    {
        GNode A = new GNode("A");
        GNode B = new GNode("B");
        GNode C = new GNode("C");
        GNode D = new GNode("D");
        GNode E = new GNode("E");
        GNode F = new GNode("F");
        GNode G = new GNode("G");
        GNode H = new GNode("H");
        GNode I = new GNode("I");
        GNode J = new GNode("J");
        GNode K = new GNode("K");
        GNode L = new GNode("L");
        nodelist.add(A);
        nodelist.add(B);
        nodelist.add(C);
        nodelist.add(D);
        nodelist.add(E);
        nodelist.add(F);
        nodelist.add(G);
        nodelist.add(H);
        nodelist.add(I);
        nodelist.add(J);
        nodelist.add(K);
        nodelist.add(L);
        createLink(A,B);
        createLink(A,C);
        createLink(A,D);
        createLink(A,E);
        createLink(A,F);
        createLink(B,G);
        createLink(B,H);   
        createLink(F,I);  
        createLink(F,J);  
        createLink(J,K);  
        createLink(K,L);  
        Scanner c = new Scanner(System.in);
        System.out.print("What letter do you want to search for :: ");
        String goal = c.next();
        System.out.println();
        for(int j = 0; j < nodelist.size();j++)
        {
            System.out.println("Startable place :: " + nodelist.get(j).toString());
        }
        System.out.print("What letter do you want to start at :: ");
        String word = c.next();
        System.out.println();
        System.out.println("Do you want to use BFS or DFS search method:: ");
        String key = c.next();
        boolean prescense = false;
        GNode start = null;
        for(int i = 0; i < nodelist.size();i++)
        {
            if(nodelist.get(i).toString().equals(word))
            {
                start = nodelist.get(i);
                prescense = true;
            }
        }
        if(prescense == false)
        {
            System.out.println("Invalid start point");
            System.exit(0);
        }
        if(key.equals("BFS"))
        {
            System.out.println("Searching using DFS");
            traverseMapBFS(start, goal);
        }
        else if(key.equals("DFS"))
        {
            System.out.println("Searching using DFS");
            traverseMapDFS(start, goal);
        }
        else
        {
            System.out.println("INVALID search method");
            System.exit(0);
        }
    }
    public void createCreativeGraph() throws Exception
    {     
        ArrayList<String> countries = new ArrayList<String>();
        File file = new File("Countries.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) 
        {
            countries.add(sc.nextLine());
        }
        System.out.println("I present a graph of the world");
        GNode Afghanistan, Albania, Algeria, Andorra, Angola, AntiguaandDeps, Argentina, Armenia, Australia, 
        Austria, Azerbaijan, Bahamas, Bahrain, Bangladesh, Barbados, Belarus, Belgium, Belize, Benin, 
        Bhutan, Bolivia, BosniaandHerzegovina, Botswana, Brazil, Brunei, Bulgaria, Burkina, Burundi, Cambodia, 
        Cameroon, Canada, CapeVerde, CentralAfricanRepublic, Chad, Chile, China, Colombia, Comoros, Congo, DRCongo , CostaRica,Cote, 
        Croatia, Cuba, Cyprus, CzechRepublic, Denmark, Djibouti, Dominica, DominicanRepublic, EastTimor, 
        Ecuador, Egypt, ElSalvador, EquatorialGuinea, Eritrea, Estonia, Eswatini, Ethiopia, Fiji, Finland, France, 
        Gabon, Gambia, Georgia, Germany, Ghana, Greece, Grenada, 
        Guatemala, Guinea, GuineaBissau, Guyana, Haiti, Honduras, Hungary, Iceland, India, Indonesia, Iran, 
        Iraq, Ireland , Israel, Italy, IvoryCoast, Jamaica, Japan, Jordan, Kazakhstan, Kenya, 
        Kiribati, NorthKorea, SouthKorea, Kosovo, Kuwait, Kyrgyzstan, Laos, Latvia, Lebanon, Lesotho, 
        Liberia, Libya, Liechtenstein, Lithuania, Luxembourg, Madagascar, Malawi, Malaysia, 
        Maldives, Mali, Malta, MarshallIslands, Mauritania, Mauritius, Mexico, Micronesia, Moldova, Monaco, 
        Mongolia, Montenegro, Morocco, Mozambique, Myanmar, Burma, Namibia, Nauru, Nepal, Netherlands, 
        NewZealand, Nicaragua, Niger, Nigeria, NorthMacedonia ,Norway, Oman, Pakistan, Palau, Palestine, Panama, PapuaNewGuinea, 
        Paraguay, Peru, Philippines, Poland, Portugal, Qatar, Romania, Russia, Rwanda,
        StKittsandNevis, StLucia, SaintVincentandtheGrenadines, Samoa, SanMarino, SaoTomeandPrincipe,
        SaudiArabia, Senegal, Serbia, Seychelles, SierraLeone, Singapore, Slovakia, Slovenia, 
        SolomonIslands, Somalia, SouthAfrica, SouthSudan, Spain, SriLanka, Sudan, Suriname, 
        Swaziland, Sweden, Switzerland, Syria, Taiwan, Tajikistan, Tanzania, Thailand, Togo, Tonga, 
        TrinidadandTobago, Tunisia, Turkey, Turkmenistan, Tuvalu, Uganda, Ukraine, UnitedArabEmirates, 
        UnitedKingdom, UnitedStates, Uruguay, Uzbekistan, Vanuatu, VaticanCity, Venezuela, Vietnam, 
        Yemen, Zambia, Zimbabwe;
        
        int i = 0;
        Afghanistan = new GNode(countries.get(i++));
        Albania = new GNode(countries.get(i++));
        Algeria = new GNode(countries.get(i++));
        Andorra = new GNode(countries.get(i++));
        Angola = new GNode(countries.get(i++));
        AntiguaandDeps = new GNode(countries.get(i++));
        Argentina = new GNode(countries.get(i++));
        Armenia = new GNode(countries.get(i++));
        Australia = new GNode(countries.get(i++));
        Austria = new GNode(countries.get(i++));
        Azerbaijan = new GNode(countries.get(i++));
        Bahamas = new GNode(countries.get(i++));
        Bahrain = new GNode(countries.get(i++));
        Bangladesh = new GNode(countries.get(i++));
        Barbados = new GNode(countries.get(i++));
        Belarus = new GNode(countries.get(i++));
        Belgium = new GNode(countries.get(i++));
        Belize = new GNode(countries.get(i++));
        Benin = new GNode(countries.get(i++));
        Bhutan = new GNode(countries.get(i++));
        Bolivia = new GNode(countries.get(i++));
        BosniaandHerzegovina = new GNode(countries.get(i++));
        Botswana = new GNode(countries.get(i++));
        Brazil = new GNode(countries.get(i++));
        Brunei = new GNode(countries.get(i++));
        Bulgaria = new GNode(countries.get(i++));
        Burkina = new GNode(countries.get(i++));
        Burundi = new GNode(countries.get(i++));
        Cambodia = new GNode(countries.get(i++));
        Cameroon = new GNode(countries.get(i++));
        Canada = new GNode(countries.get(i++));
        CapeVerde = new GNode(countries.get(i++));
        CentralAfricanRepublic = new GNode(countries.get(i++));
        Chad = new GNode(countries.get(i++));
        Chile = new GNode(countries.get(i++));
        China = new GNode(countries.get(i++));
        Colombia = new GNode(countries.get(i++));
        Comoros = new GNode(countries.get(i++));
        Congo = new GNode(countries.get(i++));
        DRCongo = new GNode(countries.get(i++));
        CostaRica = new GNode(countries.get(i++));
        Cote = new GNode(countries.get(i++));
        Croatia = new GNode(countries.get(i++));
        Cuba = new GNode(countries.get(i++));
        Cyprus = new GNode(countries.get(i++));
        CzechRepublic = new GNode(countries.get(i++));
        Denmark = new GNode(countries.get(i++));
        Djibouti = new GNode(countries.get(i++));
        Dominica = new GNode(countries.get(i++));
        DominicanRepublic = new GNode(countries.get(i++));
        EastTimor = new GNode(countries.get(i++));
        Ecuador = new GNode(countries.get(i++));
        Egypt = new GNode(countries.get(i++));
        ElSalvador = new GNode(countries.get(i++));
        EquatorialGuinea = new GNode(countries.get(i++));
        Eritrea = new GNode(countries.get(i++));
        Estonia = new GNode(countries.get(i++));
        Eswatini = new GNode(countries.get(i++));
        Ethiopia = new GNode(countries.get(i++));
        Fiji = new GNode(countries.get(i++));
        Finland = new GNode(countries.get(i++));
        France = new GNode(countries.get(i++));
        Gabon = new GNode(countries.get(i++));
        Gambia = new GNode(countries.get(i++));
        Georgia = new GNode(countries.get(i++));
        Germany = new GNode(countries.get(i++));
        Ghana = new GNode(countries.get(i++));
        Greece = new GNode(countries.get(i++));
        Grenada = new GNode(countries.get(i++));
        Guatemala = new GNode(countries.get(i++));
        Guinea = new GNode(countries.get(i++));
        GuineaBissau = new GNode(countries.get(i++));
        Guyana = new GNode(countries.get(i++));
        Haiti = new GNode(countries.get(i++));
        Honduras = new GNode(countries.get(i++));
        Hungary = new GNode(countries.get(i++));
        Iceland = new GNode(countries.get(i++));
        India = new GNode(countries.get(i++));
        Indonesia = new GNode(countries.get(i++));
        Iran = new GNode(countries.get(i++));
        Iraq = new GNode(countries.get(i++));
        Ireland = new GNode(countries.get(i++));
        Israel = new GNode(countries.get(i++));
        Italy = new GNode(countries.get(i++));
        IvoryCoast = new GNode(countries.get(i++));
        Jamaica = new GNode(countries.get(i++));
        Japan = new GNode(countries.get(i++));
        Jordan = new GNode(countries.get(i++));
        Kazakhstan = new GNode(countries.get(i++));
        Kenya = new GNode(countries.get(i++));
        Kiribati = new GNode(countries.get(i++));
        NorthKorea = new GNode(countries.get(i++));
        SouthKorea = new GNode(countries.get(i++));
        Kosovo = new GNode(countries.get(i++));
        Kuwait = new GNode(countries.get(i++));
        Kyrgyzstan = new GNode(countries.get(i++));
        Laos = new GNode(countries.get(i++));
        Latvia = new GNode(countries.get(i++));
        Lebanon = new GNode(countries.get(i++));
        Lesotho = new GNode(countries.get(i++));
        Liberia = new GNode(countries.get(i++));
        Libya = new GNode(countries.get(i++));
        Liechtenstein = new GNode(countries.get(i++));
        Lithuania = new GNode(countries.get(i++));
        Luxembourg = new GNode(countries.get(i++));
        Madagascar = new GNode(countries.get(i++));
        Malawi = new GNode(countries.get(i++));
        Malaysia = new GNode(countries.get(i++));
        Maldives = new GNode(countries.get(i++));
        Mali = new GNode(countries.get(i++));
        Malta = new GNode(countries.get(i++));
        MarshallIslands = new GNode(countries.get(i++));
        Mauritania = new GNode(countries.get(i++));
        Mauritius = new GNode(countries.get(i++));
        Mexico = new GNode(countries.get(i++));
        Micronesia = new GNode(countries.get(i++));
        Moldova = new GNode(countries.get(i++));
        Monaco = new GNode(countries.get(i++));
        Mongolia = new GNode(countries.get(i++));
        Montenegro = new GNode(countries.get(i++));
        Morocco = new GNode(countries.get(i++));
        Mozambique = new GNode(countries.get(i++));
        Myanmar = new GNode(countries.get(i++));
        Namibia = new GNode(countries.get(i++));
        Nauru = new GNode(countries.get(i++));
        Nepal = new GNode(countries.get(i++));
        Netherlands = new GNode(countries.get(i++));
        NewZealand = new GNode(countries.get(i++));
        Nicaragua = new GNode(countries.get(i++));
        Niger = new GNode(countries.get(i++));
        Nigeria = new GNode(countries.get(i++));
        NorthMacedonia = new GNode(countries.get(i++));
        Norway = new GNode(countries.get(i++));
        Oman = new GNode(countries.get(i++));
        Pakistan = new GNode(countries.get(i++));
        Palau = new GNode(countries.get(i++));
        Palestine = new GNode(countries.get(i++));
        Panama = new GNode(countries.get(i++));
        PapuaNewGuinea = new GNode(countries.get(i++));
        Paraguay = new GNode(countries.get(i++));
        Peru = new GNode(countries.get(i++));
        Philippines = new GNode(countries.get(i++));
        Poland = new GNode(countries.get(i++));
        Portugal = new GNode(countries.get(i++));
        Qatar = new GNode(countries.get(i++));
        Romania = new GNode(countries.get(i++));
        Russia = new GNode(countries.get(i++));
        Rwanda = new GNode(countries.get(i++));
        StKittsandNevis = new GNode(countries.get(i++));
        StLucia = new GNode(countries.get(i++));
        SaintVincentandtheGrenadines = new GNode(countries.get(i++));
        Samoa = new GNode(countries.get(i++));
        SanMarino = new GNode(countries.get(i++));
        SaoTomeandPrincipe = new GNode(countries.get(i++));
        SaudiArabia = new GNode(countries.get(i++));
        Senegal = new GNode(countries.get(i++));
        Serbia = new GNode(countries.get(i++));
        Seychelles = new GNode(countries.get(i++));
        SierraLeone = new GNode(countries.get(i++));
        Singapore = new GNode(countries.get(i++));
        Slovakia = new GNode(countries.get(i++));
        Slovenia = new GNode(countries.get(i++));
        SolomonIslands = new GNode(countries.get(i++));
        Somalia = new GNode(countries.get(i++));
        SouthAfrica = new GNode(countries.get(i++));
        SouthSudan = new GNode(countries.get(i++));
        Spain = new GNode(countries.get(i++));
        SriLanka = new GNode(countries.get(i++));
        Sudan = new GNode(countries.get(i++));
        Suriname = new GNode(countries.get(i++));
        Swaziland = new GNode(countries.get(i++));
        Sweden = new GNode(countries.get(i++));
        Switzerland = new GNode(countries.get(i++));
        Syria = new GNode(countries.get(i++));
        Taiwan = new GNode(countries.get(i++));
        Tajikistan = new GNode(countries.get(i++));
        Tanzania = new GNode(countries.get(i++));
        Thailand = new GNode(countries.get(i++));
        Togo = new GNode(countries.get(i++));
        Tonga = new GNode(countries.get(i++));
        TrinidadandTobago = new GNode(countries.get(i++));
        Tunisia = new GNode(countries.get(i++));
        Turkey = new GNode(countries.get(i++));
        Turkmenistan = new GNode(countries.get(i++));
        Tuvalu = new GNode(countries.get(i++));
        Uganda = new GNode(countries.get(i++));
        Ukraine = new GNode(countries.get(i++));
        UnitedArabEmirates = new GNode(countries.get(i++));
        UnitedKingdom = new GNode(countries.get(i++));
        UnitedStates = new GNode(countries.get(i++));
        Uruguay = new GNode(countries.get(i++));
        Uzbekistan = new GNode(countries.get(i++));
        Vanuatu = new GNode(countries.get(i++));
        VaticanCity = new GNode(countries.get(i++));
        Venezuela = new GNode(countries.get(i++));
        Vietnam = new GNode(countries.get(i++));
        Yemen = new GNode(countries.get(i++));
        Zambia = new GNode(countries.get(i++));
        Zimbabwe = new GNode(countries.get(i++));
        nodelist.add(Afghanistan);
        nodelist.add(Albania);
        nodelist.add(Algeria);
        nodelist.add(Andorra);
        nodelist.add(Angola);
        nodelist.add(AntiguaandDeps);
        nodelist.add(Argentina);
        nodelist.add(Armenia);
        nodelist.add(Australia);
        nodelist.add(Austria);
        nodelist.add(Azerbaijan);
        nodelist.add(Bahamas);
        nodelist.add(Bahrain);
        nodelist.add(Bangladesh);
        nodelist.add(Barbados);
        nodelist.add(Belarus);
        nodelist.add(Belgium);
        nodelist.add(Belize);
        nodelist.add(Benin);
        nodelist.add(Bhutan);
        nodelist.add(Bolivia);
        nodelist.add(BosniaandHerzegovina);
        nodelist.add(Botswana);
        nodelist.add(Brazil);
        nodelist.add(Brunei);
        nodelist.add(Bulgaria);
        nodelist.add(Burkina);
        nodelist.add(Burundi);
        nodelist.add(Cambodia);
        nodelist.add(Cameroon);
        nodelist.add(Canada);
        nodelist.add(CapeVerde);
        nodelist.add(CentralAfricanRepublic);
        nodelist.add(Chad);
        nodelist.add(Chile);
        nodelist.add(China);
        nodelist.add(Colombia);
        nodelist.add(Comoros);
        nodelist.add(Congo);
        nodelist.add(DRCongo);
        nodelist.add(CostaRica);
        nodelist.add(Croatia);
        nodelist.add(Cuba);
        nodelist.add(Cyprus);
        nodelist.add(CzechRepublic);
        nodelist.add(Denmark);
        nodelist.add(Djibouti);
        nodelist.add(Dominica);
        nodelist.add(DominicanRepublic);
        nodelist.add(EastTimor);
        nodelist.add(Ecuador);
        nodelist.add(Egypt);
        nodelist.add(ElSalvador);
        nodelist.add(EquatorialGuinea);
        nodelist.add(Eritrea);
        nodelist.add(Estonia);
        nodelist.add(Eswatini);
        nodelist.add(Ethiopia);
        nodelist.add(Fiji);
        nodelist.add(Finland);
        nodelist.add(France);
        nodelist.add(Gabon);
        nodelist.add(Gambia);
        nodelist.add(Georgia);
        nodelist.add(Germany);
        nodelist.add(Ghana);
        nodelist.add(Greece);
        nodelist.add(Grenada);
        nodelist.add(Guatemala);
        nodelist.add(Guinea);
        nodelist.add(GuineaBissau);
        nodelist.add(Guyana);
        nodelist.add(Haiti);
        nodelist.add(Honduras);
        nodelist.add(Hungary);
        nodelist.add(Iceland);
        nodelist.add(India);
        nodelist.add(Indonesia);
        nodelist.add(Iran);
        nodelist.add(Iraq);
        nodelist.add(Ireland);
        nodelist.add(Israel);
        nodelist.add(Italy);
        nodelist.add(IvoryCoast);
        nodelist.add(Jamaica);
        nodelist.add(Japan);
        nodelist.add(Jordan);
        nodelist.add(Kazakhstan);
        nodelist.add(Kenya);
        nodelist.add(Kiribati);
        nodelist.add(NorthKorea);
        nodelist.add(SouthKorea);
        nodelist.add(Kosovo);
        nodelist.add(Kuwait);
        nodelist.add(Kyrgyzstan);
        nodelist.add(Laos);
        nodelist.add(Latvia);
        nodelist.add(Lebanon);
        nodelist.add(Lesotho);
        nodelist.add(Liberia);
        nodelist.add(Libya);
        nodelist.add(Liechtenstein);
        nodelist.add(Lithuania);
        nodelist.add(Luxembourg);
        nodelist.add(Madagascar);
        nodelist.add(Malawi);
        nodelist.add(Malaysia);
        nodelist.add(Maldives);
        nodelist.add(Mali);
        nodelist.add(Malta);
        nodelist.add(MarshallIslands);
        nodelist.add(Mauritania);
        nodelist.add(Mauritius);
        nodelist.add(Mexico);
        nodelist.add(Micronesia);
        nodelist.add(Moldova);
        nodelist.add(Monaco);
        nodelist.add(Mongolia);
        nodelist.add(Montenegro);
        nodelist.add(Morocco);
        nodelist.add(Mozambique);
        nodelist.add(Myanmar);
        nodelist.add(Namibia);
        nodelist.add(Nauru);
        nodelist.add(Nepal);
        nodelist.add(Netherlands);
        nodelist.add(NewZealand);
        nodelist.add(Nicaragua);
        nodelist.add(Niger);
        nodelist.add(Nigeria);
        nodelist.add(Norway);
        nodelist.add(Oman);
        nodelist.add(Pakistan);
        nodelist.add(Palau);
        nodelist.add(Palestine);
        nodelist.add(Panama);
        nodelist.add(PapuaNewGuinea);
        nodelist.add(Paraguay);
        nodelist.add(Peru);
        nodelist.add(Philippines);
        nodelist.add(Poland);
        nodelist.add(Portugal);
        nodelist.add(Qatar);
        nodelist.add(Romania);
        nodelist.add(Russia);
        nodelist.add(Rwanda);
        nodelist.add(StKittsandNevis);
        nodelist.add(StLucia);
        nodelist.add(SaintVincentandtheGrenadines);
        nodelist.add(Samoa);
        nodelist.add(SanMarino);
        nodelist.add(SaoTomeandPrincipe);
        nodelist.add(SaudiArabia);
        nodelist.add(Senegal);
        nodelist.add(Serbia);
        nodelist.add(Seychelles);
        nodelist.add(SierraLeone);
        nodelist.add(Singapore);
        nodelist.add(Slovakia);
        nodelist.add(Slovenia);
        nodelist.add(SolomonIslands);
        nodelist.add(Somalia);
        nodelist.add(SouthAfrica);
        nodelist.add(SouthSudan);
        nodelist.add(Spain);
        nodelist.add(SriLanka);
        nodelist.add(Sudan);
        nodelist.add(Suriname);
        nodelist.add(Swaziland);
        nodelist.add(Sweden);
        nodelist.add(Switzerland);
        nodelist.add(Syria);
        nodelist.add(Taiwan);
        nodelist.add(Tajikistan);
        nodelist.add(Tanzania);
        nodelist.add(Thailand);
        nodelist.add(Togo);
        nodelist.add(Tonga);
        nodelist.add(TrinidadandTobago);
        nodelist.add(Tunisia);
        nodelist.add(Turkey);
        nodelist.add(Turkmenistan);
        nodelist.add(Tuvalu);
        nodelist.add(Uganda);
        nodelist.add(Ukraine);
        nodelist.add(UnitedArabEmirates);
        nodelist.add(UnitedKingdom);
        nodelist.add(UnitedStates);
        nodelist.add(Uruguay);
        nodelist.add(Uzbekistan);
        nodelist.add(Vanuatu);
        nodelist.add(VaticanCity);
        nodelist.add(Venezuela);
        nodelist.add(Vietnam);
        nodelist.add(Yemen);
        nodelist.add(Zambia);
        nodelist.add(Zimbabwe);
        createLink(Afghanistan, Iran);
        createLink(Afghanistan, Pakistan);
        createLink(Afghanistan, Uzbekistan);
        createLink(Afghanistan, Tajikistan);
        createLink(Afghanistan, Turkmenistan);
        createLink(Afghanistan,China);
        createLink(Albania,Greece);
        createLink(Albania,NorthMacedonia);
        createLink(Albania,Montenegro);
        createLink(Albania,Kosovo);
        createLink(Algeria,Tunisia);
        createLink(Algeria,Libya);
        createLink(Algeria,Niger);
        createLink(Algeria,Mali);
        createLink(Algeria, Mauritania);
        createLink(Algeria,Morocco);
        createLink(Andorra,France);
        createLink(Andorra,Spain);
        createLink(Angola,DRCongo);
        createLink(Angola,Congo);
        createLink(Angola,Zambia);
        createLink(Angola,Namibia);
        createLink(AntiguaandDeps,StKittsandNevis);
        createLink(Argentina,Chile);
        createLink(Argentina,Bolivia);
        createLink(Argentina,Uruguay);
        createLink(Argentina,Paraguay);
        createLink(Argentina,Brazil);
        createLink(Armenia,Azerbaijan);
        createLink(Armenia,Georgia);
        createLink(Armenia,Iran);
        createLink(Armenia,Turkey);
        createLink(Austria,CzechRepublic);
        createLink(Austria,Germany);
        createLink(Austria,Slovakia);
        createLink(Austria,Hungary);
        createLink(Austria,Slovenia);
        createLink(Austria,Switzerland);
        createLink(Austria,Liechtenstein);
        createLink(Austria,Italy);
        createLink(Azerbaijan,Iran);
        createLink(Azerbaijan,Russia);
        createLink(Azerbaijan,Georgia);
        createLink(Azerbaijan,Turkey);
        createLink(Bangladesh,India);
        createLink(Bangladesh,Myanmar);
        createLink(Belarus,Latvia);
        createLink(Belarus,Lithuania);
        createLink(Belarus,Russia);
        createLink(Belarus,Poland);
        createLink(Belarus,Ukraine);
        createLink(Belgium,France);
        createLink(Belgium,Germany);
        createLink(Belgium,Netherlands);
        createLink(Belgium,Luxembourg);
        createLink(Belize,Guatemala);
        createLink(Belize, Mexico);
        createLink(Benin,Niger);
        createLink(Benin,Nigeria);
        createLink(Benin,Togo);
        createLink(Benin,Burkina);
        createLink(Bhutan,China);
        createLink(Bhutan,India);
        createLink(Bolivia,Brazil);
        createLink(Bolivia,Chile);
        createLink(Bolivia,Paraguay);
        createLink(Bolivia,Peru);
        createLink(BosniaandHerzegovina,Croatia);
        createLink(BosniaandHerzegovina,Montenegro);
        createLink(BosniaandHerzegovina,Serbia);
        createLink(Botswana,Namibia);
        createLink(Botswana,SouthAfrica);
        createLink(Botswana,Zambia);
        createLink(Botswana,Zimbabwe);
        createLink(Brazil,Colombia);
        createLink(Brazil, France);
        createLink(Brazil,Guyana);
        createLink(Brazil,Paraguay);
        createLink(Brazil,Peru);
        createLink(Brazil,Suriname);
        createLink(Brazil,Uruguay);
        createLink(Brazil,Venezuela);
        createLink(Brunei,Malaysia);
        createLink(Bulgaria,Greece);
        createLink(Bulgaria,NorthMacedonia);
        createLink(Bulgaria,Romania);
        createLink(Bulgaria,Serbia);
        createLink(Bulgaria,Turkey);
        createLink(Burkina,Cote);
        createLink(Burkina,Ghana);
        createLink(Burkina,Mali);
        createLink(Burkina,Niger);
        createLink(Burkina,Togo);
        createLink(Burundi,DRCongo);
        createLink(Burundi,Rwanda);
        createLink(Burundi,Tanzania);
        createLink(Cambodia,Laos);
        createLink(Cambodia,Thailand);
        createLink(Cambodia,Vietnam);
        createLink(Cameroon,CentralAfricanRepublic);
        createLink(Cameroon,Chad);
        createLink(Cameroon,Congo);
        createLink(Cameroon,EquatorialGuinea);
        createLink(Cameroon,Gabon);
        createLink(Cameroon,Nigeria);
        createLink(Canada,UnitedStates);
        createLink(Canada,Denmark);
        createLink(CentralAfricanRepublic,Chad);
        createLink(CentralAfricanRepublic,DRCongo);
        createLink(CentralAfricanRepublic,Congo);
        createLink(CentralAfricanRepublic,SouthSudan);
        createLink(CentralAfricanRepublic,Sudan);
        createLink(Chad,Libya);
        createLink(Chad,Niger);
        createLink(Chad,Nigeria);
        createLink(Chad,Sudan);
        createLink(Chile,Peru);
        createLink(China,India);
        createLink(China,Kazakhstan);
        createLink(China,NorthKorea);
        createLink(China,Kyrgyzstan);
        createLink(China,Laos);
        createLink(China,Mongolia);
        createLink(China,Myanmar);
        createLink(China,Nepal);
        createLink(China,Pakistan);
        createLink(China,Russia);
        createLink(China,Tajikistan);
        createLink(China,Vietnam);
        createLink(Colombia,Ecuador);
        createLink(Colombia,Panama);
        createLink(Colombia,Peru);
        createLink(Colombia,Venezuela);
        createLink(Congo,DRCongo);
        createLink(Congo,Gabon);
        createLink(DRCongo,Rwanda);
        createLink(DRCongo,SouthSudan);
        createLink(DRCongo,Tanzania);
        createLink(DRCongo,Uganda);
        createLink(DRCongo,Zambia);
        createLink(CostaRica,Nicaragua);
        createLink(CostaRica,Panama);
        createLink(Cote,Ghana);
        createLink(Cote,Guinea);
        createLink(Cote,Liberia);
        createLink(Cote,Mali);
        createLink(Croatia,Hungary);
        createLink(Croatia,Montenegro);
        createLink(Croatia,Serbia);
        createLink(Croatia,Slovenia);
        createLink(Cyprus,UnitedKingdom);
        createLink(CzechRepublic,Poland);
        createLink(CzechRepublic,Germany);
        createLink(CzechRepublic,Slovakia);
        createLink(Denmark,Germany);
        createLink(Djibouti,Eritrea);
        createLink(Djibouti,Ethiopia);
        createLink(DominicanRepublic, Haiti);
        createLink(EastTimor,Indonesia);
        createLink(Ecuador,Peru);
        createLink(Egypt,Palestine);
        createLink(Egypt,Israel);
        createLink(Egypt,Libya);
        createLink(Egypt,Sudan);
        createLink(ElSalvador,Guatemala);
        createLink(ElSalvador, Honduras);
        createLink(EquatorialGuinea,Cameroon);
        createLink(EquatorialGuinea,Gabon);
        createLink(Eritrea,Ethiopia);
        createLink(Eritrea,Sudan);
        createLink(Estonia,Latvia);
        createLink(Estonia,Russia);
        createLink(Eswatini, Mozambique);
        createLink(Eswatini,SouthAfrica);
        createLink(Ethiopia,Kenya);
        createLink(Ethiopia,Somalia);
        createLink(Ethiopia,SouthSudan);
        createLink(Ethiopia,Sudan);
        createLink(Finland,Norway);
        createLink(Finland,Sweden);
        createLink(Finland,Russia);
        createLink(France,Germany);
        createLink(France,Italy);
        createLink(France,Luxembourg);
        createLink(France,Monaco);
        createLink(France,Netherlands);
        createLink(France,Spain);
        createLink(France,Suriname);
        createLink(France,Switzerland);
        createLink(Georgia,Russia);
        createLink(Georgia,Turkey);
        createLink(Germany,Luxembourg);
        createLink(Germany,Netherlands);
        createLink(Germany,Poland);
        createLink(Germany,Switzerland);
        createLink(Ghana,Togo);
        createLink(Greece,Turkey);
        createLink(Greece,NorthMacedonia);
        createLink(Guatemala,Honduras);
        createLink(Guatemala,Mexico);
        createLink(Guinea,GuineaBissau);
        createLink(Guinea,Liberia);
        createLink(Guinea,Mali);
        createLink(Guinea,Senegal);
        createLink(Guinea,SierraLeone);
        createLink(GuineaBissau,Senegal);
        createLink(Guyana,Suriname);
        createLink(Guyana,Venezuela);
        createLink(Honduras,Nicaragua);
        createLink(Hungary,Romania);
        createLink(Hungary,Serbia);
        createLink(Hungary,Slovakia);
        createLink(Hungary,Slovenia);
        createLink(Hungary,Ukraine);
        createLink(India,Myanmar);
        createLink(India,Nepal);
        createLink(India,Pakistan);
        createLink(India,SriLanka);
        createLink(Indonesia,Malaysia);
        createLink(Indonesia,PapuaNewGuinea);
        createLink(Iran,Iraq);
        createLink(Iran,Pakistan);
        createLink(Iran,Turkey);
        createLink(Iran,Turkmenistan);
        createLink(Iraq,Jordan);
        createLink(Iraq,Kuwait);
        createLink(Iraq,SaudiArabia);
        createLink(Iraq,Syria);
        createLink(Iraq,Turkey);
        createLink(Ireland,UnitedKingdom);
        createLink(Israel,Jordan);
        createLink(Israel,Lebanon);
        createLink(Israel,Palestine);
        createLink(Israel,Syria);
        createLink(Italy,SanMarino);
        createLink(Italy,Slovenia);
        createLink(Italy,Switzerland);
        createLink(Italy,VaticanCity);
        createLink(Jordan,Palestine);
        createLink(Jordan,SaudiArabia);
        createLink(Jordan,Syria);
        createLink(Kazakhstan,Kyrgyzstan);
        createLink(Kazakhstan,Russia);
        createLink(Kazakhstan,Turkmenistan);
        createLink(Kazakhstan,Uzbekistan);
        createLink(Kenya,Somalia);
        createLink(Kenya,SouthSudan);
        createLink(Kenya,Tanzania);
        createLink(Kenya,Uganda);
        createLink(NorthKorea,SouthKorea);
        createLink(NorthKorea,Russia);
        createLink(Kosovo,Montenegro);
        createLink(Kosovo,NorthMacedonia);
        createLink(Kosovo,Serbia);
        createLink(Kuwait,SaudiArabia);
        createLink(Kyrgyzstan,Tajikistan);
        createLink(Kyrgyzstan,Uzbekistan);
        createLink(Laos,Myanmar);
        createLink(Laos,Thailand);
        createLink(Laos,Vietnam);
        createLink(Latvia,Lithuania);
        createLink(Latvia,Russia);
        createLink(Lebanon,Syria);
        createLink(Lesotho,SouthAfrica);
        createLink(Liberia,SierraLeone);
        createLink(Libya,Niger);
        createLink(Libya,Sudan);
        createLink(Libya,Tunisia);
        createLink(Liechtenstein,Switzerland);
        createLink(Lithuania,Poland);
        createLink(Lithuania,Russia);
        createLink(Malawi,Mozambique);
        createLink(Malawi,Tanzania);
        createLink(Malawi,Zambia);
        createLink(Malaysia,Thailand);
        createLink(Mali,Mauritania);
        createLink(Mali,Niger);
        createLink(Mali,Senegal);
        createLink(Mauritania, Senegal);
        createLink(Mexico,UnitedStates);
        createLink(Moldova,Romania);
        createLink(Moldova,Ukraine);
        createLink(Mongolia,Russia);
        createLink(Montenegro,Serbia);
        createLink(Morocco,Spain);
        createLink(Mozambique,Tanzania);
        createLink(Mozambique,Zambia);
        createLink(Mozambique,Zimbabwe);
        createLink(Myanmar,Thailand);
        createLink(Namibia,SouthAfrica);
        createLink(Namibia,Zambia);
        createLink(Niger,Nigeria);
        createLink(NorthMacedonia,Serbia);
        createLink(Norway,Sweden);
        createLink(Norway,Russia);
        createLink(Oman,SaudiArabia);
        createLink(Oman,UnitedArabEmirates);
        createLink(Oman,Yemen);
        createLink(Poland,Russia);
        createLink(Poland,Slovakia);
        createLink(Poland,Ukraine);
        createLink(Portugal,Spain);
        createLink(Qatar,SaudiArabia);
        createLink(Romania,Serbia);
        createLink(Romania,Ukraine);
        createLink(Russia,Ukraine);
        createLink(Rwanda,Tanzania);
        createLink(Rwanda,Uganda);
        createLink(SaudiArabia,UnitedArabEmirates);
        createLink(SaudiArabia,Yemen);
        createLink(Slovakia,Ukraine);
        createLink(SouthAfrica,Zimbabwe);
        createLink(SouthSudan,Uganda);
        createLink(SouthSudan,Sudan);
        createLink(Syria,Turkey);
        createLink(Tajikistan,Uzbekistan);
        createLink(Tanzania,Uganda);
        createLink(Tanzania,Zambia);
        createLink(Turkmenistan,Uzbekistan);
        createLink(Zambia,Zimbabwe);
        
        Scanner c = new Scanner(System.in);
        System.out.print("What country do you want to search for :: ");
        String goal = c.next();
        System.out.println();
        for(int j = 0; j < nodelist.size();j++)
        {
            System.out.println("Startable place :: " + nodelist.get(j).toString());
        }
        System.out.print("What country do you want to start at :: ");
        String word = c.next();
        System.out.println();
        System.out.println("Do you want to use BFS or DFS search method:: ");
        String key = c.next();
        boolean prescense = false;
        GNode start = null;
        for(int k = 0; k < nodelist.size();k++)
        {
            if(nodelist.get(k).toString().equals(word))
            {
                start = nodelist.get(k);
                prescense = true;
            }
        }
        if(prescense == false)
        {
            System.out.println("Invalid start point");
            System.exit(0);
        }
        if(key.equals("BFS"))
        {
            System.out.println("Searching using BFS");
            traverseMapBFS(start, goal);
        }
        else if(key.equals("DFS"))
        {
            System.out.println("Searching using DFS");
            traverseMapDFS(start, goal);
        }
        else
        {
            System.out.println("INVALID search method");
            System.exit(0);
        }
       
    }
    public void createLink(GNode node, GNode node2)
    {
        if(node.hasLink(node2))
        {
            System.out.println(node.toString() + " and " + node2.toString()+" Already linked");
        }
        else
        {
            System.out.println("Link formed between " + node.toString() + " and " + node2.toString());
            node.addLink(node2);
            node2.addLink(node);
        }
    }
    public void traverseMapBFS(GNode start, String goal)
    {
        ArrayList<GNode> searched = new ArrayList<GNode>();
        ArrayList<GNode> fringe = new ArrayList<GNode>();
        GNode temp = start;
        fringe.add(start);
        while(!goal.equals(temp.toString()))
        {
            if(fringe.size()!=0)
            {
                temp = fringe.remove(0);
                for(int i = 0; i<temp.accessList().size();i++)
                {
                    boolean remain = false;
                    for(int j = 0; j < searched.size();j++)
                    {
                        if(searched.get(j).toString().equals(temp.accessList().get(i).toString()))
                        {
                            remain = true;
                        }
                    }
                    if(remain == false)
                    {
                        fringe.add(temp.accessList().get(i));
                    }
                    else
                    {
                        remain = false;
                    }
                }
                boolean inlist = false;
                for(int searching = 0; searching < searched.size();searching++)
                {
                    if(temp.toString().equals(searched.get(searching).toString()))
                    {
                        inlist=true;
                    }
                } 
                if(inlist==false)
                {
                    searched.add(temp);
                    System.out.println("Visited "+temp.toString());
                }
                else
                {
                    inlist=false;
                }
            }
            else
            {
                System.out.println("Did not find " + goal);
                break;
            }
        }
    }
    public void printFringe(ArrayList<GNode> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println("There is " + list.get(i).toString() + " in the fringe");
        }
    }
    public void traverseMapDFS(GNode start, String goal)
    {
        ArrayList<GNode> searched = new ArrayList<GNode>();
        ArrayList<GNode> fringe = new ArrayList<GNode>();
        GNode temp = start;
        fringe.add(start);
        while(!goal.equals(temp.toString()))
        {
            if(fringe.size()!=0)
            {
                temp = fringe.remove(fringe.size()-1);
                for(int i = 0; i<temp.accessList().size();i++)
                {
                    boolean remain = false;
                    for(int j = 0; j < searched.size();j++)
                    {
                        if(searched.get(j).toString().equals(temp.accessList().get(i).toString()))
                        {
                            remain = true;
                        }
                    }
                    if(remain == false)
                    {
                        fringe.add(temp.accessList().get(i));
                    }
                    else
                    {
                        remain = false;
                    }
                }
                boolean inlist = false;
                for(int searching = 0; searching < searched.size();searching++)
                {
                    if(temp.toString().equals(searched.get(searching).toString()))
                    {
                        inlist=true;
                    }
                } 
                if(inlist==false)
                {
                    searched.add(temp);
                    System.out.println("Visited "+temp.toString());
                }
                else
                {
                    inlist=false;
                }
            }
            else
            {
                System.out.println("Did not find " + goal);
                break;
            }
        }
    }
}
