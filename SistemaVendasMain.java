
package br.edu.infnet.sistemavendas;

import java.util.Scanner;

public class SistemaVendasMain {
    
    private static String[] nomes;
    private static float[] vendas;
    
    private static int index;
    
    private static final int QTD = 10;
    private static final double SALARIO_BRUTO = 1_100;
    private static final double PORC_VENDAS = 0.033;
    private static final double INSS = 200;
    private static final double META = 36000;
    
    public static void main(String[] args) {
        
        nomes = new String[QTD];
        vendas = new float[QTD];
        
        String opcao = null;
        
        do{
            System.out.println("==================");
            System.out.println("Sistema vendedores");
            System.out.println("==================");
            System.out.println("[1] Cadastrar vendedor");
            System.out.println("[2] Visualizar dados do vendedor");
            System.out.println("[3] Listar vendedores cadastrados");
            System.out.println("[4] Sair");

           opcao = ler().next();
            
            switch(opcao){
                
                case "1" :
                    if (index < QTD){
                        System.out.println("Informe o nome do vendedor: ");
                        nomes[index] = ler().nextLine();
                        System.out.println("Informe valor de venda do mês em R$:");
                        vendas[index] = ler().nextFloat();
                        
                        System.out.println("Vendedor cadastrado com sucesso!");
                        
                        index++;
                    }
                    else{
                        System.out.println("Armazenamento cheio...");
                    }
                    break;
                case "2" :
                    System.out.println("informe a posição do vendedor: ");
                    int pos = ler().nextInt();
                    imprimir(pos);
                    
                    break;
                case "3" :
                    System.out.println("======================");
                    System.out.println("Vendedores cadastrados");
                    System.out.println("======================");
                    for (int i = 0; i < index; i++) {
                        imprimir(i);
                    }
                    break;
                case "4" :
                    break;
                default:
                    System.out.println("ERRO: Opção inválida");
                    break;
            }
        }while(!opcao.equals("4"));
        
        exibirRelatório();
        ler().close();
    }
    
    private static Scanner ler(){
        Scanner in = new Scanner(System.in);
        return in;
    }
    
    private static double calcularSalario(int idx){
        return ((SALARIO_BRUTO - INSS) + (vendas[idx] * PORC_VENDAS));          
    }
    
    private static String obterSituacaoVendedor(int idx){
        if (vendas[idx] < META){
            return "Não bateu a meta";
        }
        return "Bateu a meta";
    }
    
    private static void imprimir(int idx){
        double salarioliquido = calcularSalario(idx);
        String situacao = obterSituacaoVendedor(idx);
        System.out.println("===========================");
        System.out.printf("N°: %d\nNome: %s\nVendas do mês: R$%.2f\nSalário calculado: R$%.2f\n%s\n",
                idx + 1,
                nomes[idx],
                vendas[idx],
                salarioliquido,
                situacao);
    }
    
    private static double calcularMediaVendas(){
        int soma = 0;
        for (int i = 0; i < index; i++) {
            soma += vendas[i];
        }
        return soma / index;
    }
    
    private static void exibirRelatório(){
        int qtd = index;
        System.out.println("==========");
        System.out.println("Relatório");
        System.out.println("==========");
        System.out.println("Vendedores cadastrados: " + qtd);
        System.out.printf("Média de venda esse mês: R$%.2f", calcularMediaVendas());
        
    }
            
            
            
            
            
}
