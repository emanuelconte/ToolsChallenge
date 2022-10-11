INSERT INTO Descricao (valor, dataHora, estabelecimento, nsu, codigoAutorizacao, status)  VALUES
  ('50', '07/10/2022 18:30:00','PetShop Mundo cão','1234567890','1455867','AUTORIZADO'),
  ('80', '09/10/2022 15:20:00','PetShop Mundo cão','1234567890','8967857','NEGADO'),
  ('135', '10/10/2022 14:30:00','PetShop Mundo cão','1234567890','785896','AUTORIZADO');
  
  
  INSERT INTO FormaPagamento (tipo, parcelas) VALUES
  ('AVISTA', '1'),
  ('PARCELADO LOJA', '6'),
  ('PARCELADO EMISSOR', '8');

  INSERT INTO Transacao (id, cartao, DescricaoId, FormaPagamentoId) VALUES
  (100023901,'333******1234',1,1),
  (100023902,'444******4567',2,2),
  (100023903,'555******6789',3,3);

  INSERT INTO Pagamento (TransacaoId) VALUES
  (100023901), (100023902);
  
  INSERT INTO Estorno (TransacaoId) VALUES
  (100023903);