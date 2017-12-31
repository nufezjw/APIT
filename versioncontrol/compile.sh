python extractor.py VersionControl.mk
pandoc -V geometry='margin=1in' --toc -o notes.pdf VersionControl.mk.notes
./compile_html.sh
pandoc -t BEAMER --toc -o slides.pdf VersionControl.mk.slides