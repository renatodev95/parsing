package enums;

public enum Links {
    PLACA("https://www.kabum.com.br/produto/165713/placa-de-video-xfx-speedster-qick319-amd-radeon-rx-6700xt-black-gaming-16gbps-12gb-gddr6-amd-rdna-2-architecture-rx-67xtypbdp"),
    PROCESSADOR("https://www.kabum.com.br/produto/129451/processador-amd-ryzen-5-5600x-cache-35mb-3-7ghz-4-6ghz-max-turbo-am4-sem-video-100-100000065box"),
    RAM("https://www.kabum.com.br/produto/166052/memoria-xpg-gammix-d45-8gb-3200mhz-ddr4-cl16-preta-ax4u32008g16a-cbkd45"),
    MOBO("https://www.kabum.com.br/produto/108346/placa-mae-asus-tuf-gaming-x570-plus-br-amd-am4-atx-ddr4"),
    SSD1("https://www.kabum.com.br/produto/127699/ssd-xpg-s41-tuf-256gb-m-2-pcie-leituras-3500mb-s-gravacoes-1000mb-s-agammixs41-256g-c"),
    SSD2("https://www.kabum.com.br/produto/127700/ssd-xpg-s41-tuf-512gb-m-2-pcie-leituras-3500mb-s-e-gravacoes-2400mb-s-agammixs41-512g-c"),
    FONTE("https://www.kabum.com.br/produto/103281/fonte-xpg-core-reactor-750w-80-plus-gold-modular"),
    COOLER("https://www.kabum.com.br/produto/108785/water-cooler-xpg-levante-240-240mm-argb-levante240-bkcww"),
    GABINETE("https://www.kabum.com.br/produto/144984/gabinete-gamer-xpg-starker-compact-mid-tower-2x-fan-1x-traseira-argb-1x-frontal-lateral-em-vidro-temperado-preto-75260179"),
    MONITOR("https://www.kabum.com.br/produto/131233/monitor-gamer-zowie-xl2411k-24-144hz-1ms-hdmi-tecnologia-dyac-ajuste-de-altura-9h-ljplb-qbl");
    
    private final String enderecoWeb;

    Links(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }
}
