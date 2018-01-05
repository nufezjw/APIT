python extractor.py ThreadingNotes.mk
pandoc -V geometry='margin=1in' --toc -o notes.pdf ThreadingNotes.mk.notes
./compile_html.sh
pandoc -t BEAMER --toc -o slides.pdf ThreadingNotes.mk.slides