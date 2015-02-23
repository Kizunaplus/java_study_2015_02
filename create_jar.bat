@del /s /q out
@mkdir out

@javac -d out\ -cp src\ src\ball\BallReflection.java

@pushd out
@jar cvf ..\Ball.jar -C . ball

mkdir \META-INF\
@copy ..\META-INF META-INF\

@jar uvfm ..\Ball.jar META-INF\MANIFEST.MF
@popd

java -jar Ball.jar -T wind -width 800 -height 600