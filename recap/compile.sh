python extractor.py recap.mk
pandoc -V geometry='margin=1in' --toc -o notes.pdf recap.mk.notes
./compile_html.sh
pandoc -t BEAMER --toc -o slides.pdf recap.mk.slides