python extractor.py Introduction.mk
pandoc -V geometry='margin=1in' --toc -o notes.pdf Introduction.mk.notes
./compile_html.sh
pandoc -t BEAMER --toc -o slides.pdf Introduction.mk.slides