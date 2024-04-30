CREATE DATABASE dataSight;
USE dataSight;


CREATE TABLE Empresa(
	idEmpresa INT PRIMARY KEY AUTO_INCREMENT,
	Razao_Social VARCHAR(45) NOT NULL,
	CNPJ CHAR(18) NOT NULL, -- ARUMAR A ENTRADA DE CNPJ
	Telefone CHAR(15),
	email VARCHAR(45) NOT NULL,-- ARUMAR A ENTRADA DE CNPJ
    senha VARCHAR(45) NOT NULL
);

CREATE TABLE Endereco(
	idEndereco INT PRIMARY KEY AUTO_INCREMENT,
	Logradouro VARCHAR(45) NOT NULL,
	Numero INT NOT NULL,
	fkEmpresa INT NOT NULL,
	CONSTRAINT fk_idEmpresa FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa)
);
CREATE TABLE Customizacoes(
	idCustomizacao INT PRIMARY KEY AUTO_INCREMENT,
	Foco varchar(50) NOT NULL,
	Descricao varchar(200)NOT NULL,
	Valor Double NOT NULL,
	fkEmpresa int NOT NULL,
	CONSTRAINT fk_idEmpresaCustom FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa)
);
CREATE TABLE Maquina(
	idMaquina INT PRIMARY KEY AUTO_INCREMENT,
	NumeroPatrimonio CHAR(7) NOT NULL,
	NumeroRack INT NOT NULL,
	fkEmpresa INT NOT NULL,
	CONSTRAINT fk_idEmpresaMaq FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa)
);

CREATE TABLE Usuario(
	idUsuario INT PRIMARY KEY AUTO_INCREMENT,
	nome varchar(45) NOT NULL,	
	email VARCHAR(45) NOT NULL,
	senha CHAR(16) NOT NULL,
	fkEmpresa INT NOT NULL,
	CONSTRAINT fkIdEmpresaUser FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa),
    criarUsuario VARCHAR(3) NOT NULL CHECK (criarUsuario IN ('sim', 'nao'))
);



CREATE TABLE UsuarioMaquina(
	idUsuarioMaquina INT PRIMARY KEY,
	fkMaquina INT NOT NULL,
	fkUsuario INT NOT NULL,
	CONSTRAINT fkidMaquinaSetor FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina),
	CONSTRAINT fkUsuarioSetor FOREIGN KEY (fkUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE CPU(
	idCPU INT PRIMARY KEY AUTO_INCREMENT,
	Uso DOUBLE ,
	TempoAtividade TIME ,
	VelocidadeGhz DOUBLE ,
	DataHoraLeitura DATETIME ,
	fkMaquina INT,
	CONSTRAINT fkMaquinaCPU FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)

);

  CREATE TABLE CPUSpec(
                	idCPUSpec INT PRIMARY KEY AUTO_INCREMENT,
                	fabricante varchar(255)  ,
                	nome varchar(255) ,
                	identificador varchar(200) ,
                    temperatura DOUBLE,
                	qtdNucleo int ,
                	frequenciaGHz DOUBLE  ,
                	fkCPU INT,
                	CONSTRAINT fkCPUSpecCPU FOREIGN KEY (fkCPU) REFERENCES CPU(idCPU));
           
           select * from cpu;
CREATE TABLE HD(
	idHD INT PRIMARY KEY AUTO_INCREMENT,
	UsoDiscoPorcentagem Double ,
	DataHoraLeitura DATETIME,
	fkMaquina INT,
	CONSTRAINT fkMaquinaHD FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
	-- fkEmpresa INT NOT NULL,
	-- CONSTRAINT fk_idEmpresaHD FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa),
    -- teria que ter uma fk do rack aqui -- 
);
					
CREATE TABLE HDSpec(
	idHDSpec INT PRIMARY KEY AUTO_INCREMENT,
	modelo varchar(45) not null,
	tamanho DOUBLE NOT NULL,
	Leitura Double not null,
	fkHD INT NOT NULL,
	CONSTRAINT fkHDSpecHD FOREIGN KEY (fkHD) REFERENCES HD(idHD)
);

CREATE TABLE RAM(
	idRAM INT PRIMARY KEY AUTO_INCREMENT,
	EmUso DOUBLE NOT NULL,
	Total DOUBLE NOT NULL,
	Disponivel DOUBLE NOT NULL,
	DataHoraLeitura DATETIME NOT NULL,
	fkMaquina INT NOT NULL,
	CONSTRAINT fk_idMaquinaRAM FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
	-- fkEmpresa INT NOT NULL,
	-- CONSTRAINT fk_idEmpresaRAM FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa),
    -- teria que ter uma fk do rack aqui -- 
);

CREATE TABLE RAMSpec(
	idRAMSpec INT PRIMARY KEY AUTO_INCREMENT,
	marca varchar(45) not null,
	modelo varchar(45) not null,
	armazenamentoTotal DOUBLE NOT NULL,
	DDR DATETIME NOT NULL,
	fkRAM INT NOT NULL,
	CONSTRAINT fkRAMSpecRAM FOREIGN KEY (fkRAM) REFERENCES RAM(idRAM)
);

CREATE TABLE Rede(
	idPlacaRede INT PRIMARY KEY AUTO_INCREMENT,
	TaxaTransferencia DOUBLE NOT NULL,
	TaxaUpload DOUBLE NOT NULL,
	TaxaDownload DOUBLE NOT NULL,
	DataHoraLeitura DATETIME NOT NULL,
	fkMaquina INT NOT NULL,
	CONSTRAINT fk_idMaquinaRED FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
);
CREATE TABLE RedeSpec(
	idRedeSpec INT PRIMARY KEY AUTO_INCREMENT,
	marca varchar(45) not null,
	modelo varchar(45) not null,
	taxaTransferenciaMbps DOUBLE NOT NULL,
	fkrede INT NOT NULL,
	CONSTRAINT fkRedeSpecREDE FOREIGN KEY (fkrede) REFERENCES Rede(idPlacaRede)
);


SELECT * FROM Empresa;
SELECT * FROM Usuario;
SELECT * FROM Empresa ORDER BY idEmpresa DESC LIMIT 1;


INSERT INTO Empresa (Razao_Social, CNPJ, Telefone, email, senha) VALUES
('Tech Solutions Ltda', '12.345.678/0001-91', '(11) 9999-8888', 'contato@techsolucoes.com.br', 'senha123'),
('Data Driven Analytics S/A', '98.765.432/0001-10', '(21) 8888-7777', 'support@datadriven.com', 'senha456'),
('Cloud Services Inc.', '56.789.123/0001-55', '(19) 7777-6666', 'services@cloudservices.com', 'senha789');

INSERT INTO Endereco (Logradouro, Numero, fkEmpresa) VALUES
('Av. Paulista', 1500, 1),
('Rua das Flores', 290, 2),
('Blvd. Sunset', 300, 3);

INSERT INTO Customizacoes (Foco, Descricao, Valor, fkEmpresa) VALUES
('Software', 'Personalização de ERP', 5000.00, 1),
('Hardware', 'Customização de servidores', 8000.00, 2);

INSERT INTO Maquina (NumeroPatrimonio, NumeroRack, fkEmpresa) VALUES
('0011223', 1, 1),
('0011224', 1, 2),
('0011225', 2, 1);

INSERT INTO Usuario (nome, email, senha, fkEmpresa, criarUsuario) VALUES
('João Silva', 'joao.silva@techsolucoes.com.br', '1234abcd', 1, 'sim'),
('Maria Oliveira', 'maria.oliveira@datadriven.com', 'abcd1234', 2, 'nao');



INSERT INTO Maquina (NumeroPatrimonio, NumeroRack, fkEmpresa) VALUES
('0011223', 1, 1),
('0011224', 1, 2),
('0011225', 2, 1);

INSERT INTO UsuarioMaquina (idUsuarioMaquina, fkMaquina, fkUsuario) VALUES
(1, 1, 1),
(2, 2, 2);

