# Vars
%FILE=dictaat
FILE=verslag
SCP=scp -i ../id_rsa_pdf 
DEST=linux@hosthuis.nl:/var/www/linux/.

MAKE=make
CP=cp
RM=rm
MV=mv

all: build

build:
	@${CP} ../latex-makefile .
	@${MAKE} -f latex-makefile ${FILE}
	@${MV} ${FILE}.pdf ${FILE}.org.pdf
	@${MAKE} -f latex-makefile clean
	@${MV} ${FILE}.org.pdf ${FILE}.pdf
	@${RM} latex-makefile

