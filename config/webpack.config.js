const { VueLoaderPlugin } = require('vue-loader');
const { DefinePlugin } = require('webpack');
const path = require('path');

module.exports = {
  entry: {
    main: path.resolve(__dirname, '../client/index.js'),
  },
  output: {
    path: path.resolve(__dirname, '../src/main/resources/static'),
    filename: 'bundle.js',
    publicPath: '/',
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
        },
        exclude: file => (
          /node_modules/.test(file) &&
          !/\.vue\.js/.test(file)
        )
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader',
      },
      {
        test: /\.css$/,
        use: ['vue-style-loader', 'style-loader', 'css-loader'],
      },
      {
        test: /\.scss$/,
        use: [
          'vue-style-loader',
          'css-loader',
          {
            loader: 'sass-loader',
            options: {
              sassOptions: {
                indentedSyntax: true,
              },
            },
          },
        ],
      },
    ],
  },
  plugins: [
    new VueLoaderPlugin(), 
    new DefinePlugin({
      __VUE_OPTIONS_API__: true,
      __VUE_PROD_DEVTOOLS__: true,
    })],
  resolve: {
    extensions: ['*', '.js', '.vue', '.json'],
    modules: ['node_modules']
  },
  devtool: 'inline-source-map',
  devServer: {
    port: 8080,
    static: {
      directory: path.join(__dirname, '../src/main/resources'),
    },
  },
};
