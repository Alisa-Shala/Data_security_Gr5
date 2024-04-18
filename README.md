<h1><strong> Enkriptimi dhe dekriptimi permes teknikes Playfair Cipher ne Java</strong></h1>



Playcipher Java eshte nje menyre enkriptimi i tekstit qe e perdor nje tabele(matrice) 5*5 te mbushur me nje qeles te caktuar. Kjo tabele eshet e vlefshme per shkak se nuk eshte e lehte me u dekriptu pa e ditur qelsin. Kjo teknike eshte inventuar nga Charles Wheatstone.

Eshte nje teknike e enkriptimit simetrik .Kjo teknik kodon cifte shkronjash ne vend te shkrojave individuale duke perdorur matricen ,e cila zgjerohet duke perdorur nje celes e cila shton cdo shkronj te tij por duke i hequr duplikatat.Me pas na shtohen shkronjat e mbetura te alfabetit ,si dhe shkronja "i" dhe "J" trajtohen si e njejta shkronje dhe kjo per shkak se matrica i ka 25 kutia ndersa alfabeti i gjuhes angleze i ka 26 shkronja.

<strong>Si e enkriptojme mesazhin?</strong>

Se pari e ndertojme matricen e mbushim me celsin dhe pastaj me shkronjat tjera. I ndertojme diagramet(qe paraqesin cifte te shkronjave) dhe shikojme se ku gjenden pra shkronjat.
Ekzistojne disa raste:

1:Nese jane ne te njeten row vetem zevendesojme shkronjat me shkronjen ne te djathte te tyre.

2:Nese jane ne te njeten kolone vetem i zevendesojme shkronjat qe jane poshte tyre.

3: Nese nuk jane ne te njeten kolone ose row vetem zevendesojme me shkronjen ne te njejtin rresht por ne kolonen tjeter te ciftit.

Anetaret e grupit:
Alisa Shala,
Arbana Neziraj,
Andi Ternava ,
Amir Balje.



