rm -fr app-module custom-runtime
mkdir -p app-module
jmod create --class-path classes/ --main-class org.hsmak.RunnerOfHelloWorld --module-version 1.0.0 -p classes app-module/RunnerOfHelloWorld.jmod

jdeps -s .

jlink --launcher run=modular.java/org.hsmak.RunnerOfHelloWorld --module-path app-module --add-modules modular.java --output custom-runtime --strip-debug --no-man-pages --no-header-files --compress=2

